package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.DTO.CompileResultDTO;
import com.hqz.hzuoj.entity.DTO.JudgeDataDTO;
import com.hqz.hzuoj.entity.DTO.JudgeResultDTO;
import com.hqz.hzuoj.entity.model.Language;
import com.hqz.hzuoj.service.CompilerService;
import com.hqz.hzuoj.service.JudgeService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 编译器
 */
@Service
public class CompilerServiceImpl implements CompilerService {

    @Autowired
    private JudgeService judgeService;

    /**
     * 获取编译输出结果.
     *
     * @param language      - 编译语言
     * @param workDirectory - 编译输出目录
     * @param baseFileName  - 编译输出文件名
     * @return 包含编译输出结果的Map<String, Object>对象
     */
    @Override
    public CompileResultDTO getCompileResult(Language language, String workDirectory, String baseFileName) {
        String cmd = getCompileCmd(language, workDirectory, baseFileName);
        String compileInfoPath = getCompileInfoPath(workDirectory, baseFileName);
        return getCompileResult(cmd, compileInfoPath);
    }

    /**
     * 获取编译命令.
     *
     * @param language      - 编译语言
     * @param workDirectory - 编译输出目录
     * @param baseFileName  - 编译输出文件名
     * @return 编译命令
     */
    private String getCompileCmd(Language language, String workDirectory, String baseFileName) {
        String filePathWithoutExtension = String.format("%s/%s", workDirectory, baseFileName);
        return language.getCompileCmd().replaceAll("\\{filename\\}", filePathWithoutExtension);
    }

    /**
     * 获取编译输出结果.
     *
     * @param cmd             - 编译命令
     * @param compileInfoPath - 编译信息输出路径
     * @return 包含编译输出结果的Map<String, Object>对象
     */
    private CompileResultDTO getCompileResult(String cmd, String compileInfoPath) {
        JudgeDataDTO judgeDataDTO = new JudgeDataDTO();
        judgeDataDTO.setCmd(cmd);
        judgeDataDTO.setOutputPath(compileInfoPath);
        judgeDataDTO.setInputPath("");
        /*测评系统去编译代码，得到返回结果compileResult*/
        JudgeResultDTO judgeResult = judgeService.getCompileResult(judgeDataDTO);
        CompileResultDTO compileResult = new CompileResultDTO();
        boolean compileSuccess = false;
        if (judgeResult != null) {
            int exitCode = judgeResult.getExitCode();
            compileSuccess = (exitCode == 0);
        }
        compileResult.setCompileSuccess(compileSuccess);
        compileResult.setCompileInfo(getCompileOutput(compileInfoPath));
        //编译正常:true，编译出错:false
        return compileResult;
    }

    /**
     * 获取编译信息内容.
     *
     * @param compileInfoPath - 编译信息存放路径
     * @return 编译信息内容
     */
    private String getCompileOutput(String compileInfoPath) {
        FileInputStream inputStream = null;
        String compileInfo = "";
        try {
            inputStream = new FileInputStream(compileInfoPath);
            compileInfo = IOUtils.toString(inputStream,"UTF-8");
            compileInfo = compileInfo.substring(0, 500);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return compileInfo;
    }

    /**
     * 获取编译信息输出的文件路径.
     *
     * @param workDirectory - 编译输出目录
     * @param baseFileName  - 编译输出文件名
     * @return 编译信息输出的文件路径
     */
    public String getCompileInfoPath(String workDirectory, String baseFileName) {
        return String.format("%s/%s_compileInfo.txt", workDirectory, baseFileName);
    }

}
