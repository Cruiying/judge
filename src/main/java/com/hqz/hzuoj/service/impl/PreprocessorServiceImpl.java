package com.hqz.hzuoj.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.hqz.hzuoj.common.constants.ConfigConstants;
import com.hqz.hzuoj.common.exception.MyException;
import com.hqz.hzuoj.config.CloudStorageConfig;
import com.hqz.hzuoj.entity.model.Language;
import com.hqz.hzuoj.entity.model.Problem;
import com.hqz.hzuoj.entity.model.Test;
import com.hqz.hzuoj.service.PreprocessorService;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import net.lingala.zip4j.core.ZipFile;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.hutool.http.HttpUtil;
import java.io.*;
import java.net.URLEncoder;

/**
 * 预处理器
 */
@Service
public class PreprocessorServiceImpl implements PreprocessorService {

    @Autowired
    private ConfigConstants config;

    @Autowired
    private CloudStorageConfig qiniuConfig;

    /**
     * 创建运行代码至本地磁盘.
     *
     * @param userCode      创建用户需要保存的代码
     * @param language      保存使用的语言
     * @param workDirectory 用于产生编译输出的目录
     * @param baseFileName  随机文件名(不包含后缀)
     * @throws NotFoundException
     * @throws IOException
     */
    @Override
    public void createRuntimeCode(String userCode, Language language, String workDirectory, String baseFileName) throws IOException {
        File workDirFile = new File(workDirectory);
        if (!workDirFile.exists() && !workDirFile.mkdirs()) {
            throw new MyException("运行目录不存在");
        }
        //设置编译运行目录下的文件权限
        setWorkDirectoryPermission(workDirFile);
        //运行代码的替换
        String code = replaceClassName(language, userCode, baseFileName);
        //创建
        String codeFilePath = String.format("%s/%s.%s", workDirectory, baseFileName, getCodeFileSuffix(language));
        //将代码写入磁盘
        FileOutputStream outputStream = new FileOutputStream(new File(codeFilePath));
        IOUtils.write(code, outputStream, "UTF-8");
        IOUtils.closeQuietly(outputStream);
    }

    /**
     * 加载题目的测试数据
     *
     * @param problem
     * @return
     * @throws IOException
     */
    @Override
    public String loadProblemData(Problem problem)  {
        String problemDataAddress = problem.getDataAddress();
        String problemDataVersions = problem.getDataVersion();
        if (problemDataVersions == null) {
            return "error";
        }
        if (problemDataAddress == null) {
            return "error";
        }
        //下载路径
        String filepath = config.problemDataPath + problem.getProblemId();
        //解压路径
        String dataZipPath = config.submitCasePath  + problem.getProblemId();
        //确保路径存在
        File downloadPath= new File(filepath);
        File dataZipFilePath = new File(dataZipPath);
        if (!downloadPath.exists()) {
            downloadPath.mkdirs();
        }
        if (!dataZipFilePath.exists()) {
            dataZipFilePath.mkdirs();
        }
        String saveFile = filepath + "/data_" + problemDataVersions + ".zip";
        File zipFile = new File(saveFile);
        //该版本的数据是否已经存在
        if (zipFile.exists()) {
            return "success";
        }
        try {
            HttpUtil.downloadFile(problemDataAddress, FileUtil.file(saveFile));
            ZipFile zip = new ZipFile(zipFile);
            zip.extractAll(dataZipPath);
        } catch (Exception e) {
            //如果发生异常，删除数据
            e.printStackTrace();
            if (zipFile.exists()) {
                zipFile.delete();
            }
        }
        return "success";
    }

    /**
     * 将文件名fileName下载文件到path
     * @param fileName
     * @param path
     */
    @Override
    public void download(String fileName, String path) {
        String encodedFileName = null;
        try {
            encodedFileName = URLEncoder.encode(fileName, "utf-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String publicUrl = String.format("%s/%s", qiniuConfig.getQiniuBucketName(), encodedFileName);
        Auth auth = Auth.create(qiniuConfig.getQiniuAccessKey(), qiniuConfig.getQiniuSecretKey());
        //1小时，可以自定义链接过期时间
        long expireInSeconds = 3600;
        String finalUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);
        System.out.println(finalUrl);
        //下载
        HttpUtil.downloadFile(finalUrl, FileUtil.file(path));
    }
    /**
     * 获取代码文件的后缀名.
     *
     * @param language - 编程语言对象
     * @return 代码文件的后缀名
     */
    private String getCodeFileSuffix(Language language) {
        return language.getSuffix();
    }

    /**
     * 替换部分语言中的类名(如Java), 以保证正常通过编译.
     *
     * @param language     - 编程语言对象
     * @param code         - 待替换的代码
     * @param newClassName - 新的类名
     */
    private String replaceClassName(Language language, String code, String newClassName) {
        if (!"Java".equalsIgnoreCase(language.getName())) {
            return code;
        }
        return code.replaceAll("class[ \n]+Main", "class " + newClassName);
    }

    /**
     * 设置代码文件所在目录的读写权限.
     *
     * @param workDirectory 用于产生编译输出的目录
     */
    private void setWorkDirectoryPermission(File workDirectory) throws IOException {

    }


    /**
     * 保存用户的自测输入输出信息
     *
     * @param test
     */
    @Override
    public void saveTestData(Test test) throws IOException {
        synchronized (this) {
            String checkpointsFilePath = String.format("%s/%s", config.judgeTestPath, test.getTestId());
            File checkpointsDirFile = new File(checkpointsFilePath);
            if (!checkpointsDirFile.exists() && !checkpointsDirFile.mkdirs()) {
                throw new MyException("Failed to create the checkpoints directory: " + checkpointsFilePath);
            }
            {
                String inputFilePath = String.format("%s/input#%s.in", checkpointsFilePath, test.getTestId());
                FileOutputStream inputStream = new FileOutputStream(new File(inputFilePath));
                String input = test.getInput();
                IOUtils.write(input, inputStream, "UTF-8");
                IOUtils.closeQuietly(inputStream);
                inputStream.close();
            }
            {
                String outputFilePath = String.format("%s/output#%s.out", checkpointsFilePath, test.getTestId());
                FileOutputStream outputStream = new FileOutputStream(new File(outputFilePath));
                String output = test.getOutput();
                IOUtils.write(output, outputStream, "UTF-8");
                IOUtils.closeQuietly(outputStream);
                outputStream.close();
            }
        }

    }

}
