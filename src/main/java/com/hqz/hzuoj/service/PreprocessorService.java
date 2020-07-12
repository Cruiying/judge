package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.model.Language;
import com.hqz.hzuoj.entity.model.Problem;
import com.hqz.hzuoj.entity.model.Test;

import java.io.IOException;

public interface PreprocessorService {

    /**
     * 创建运行代码至本地磁盘
     * @param userCode
     * @param language
     * @param workDirectory
     * @param baseFileName
     * @throws IOException
     */
    public void createRuntimeCode(String userCode, Language language, String workDirectory, String baseFileName) throws IOException;


    /**
     * 加载题目数据
     * @param problem
     * @return
     */
    public String loadProblemData(Problem problem);


    /**
     * 下载文件
     * @param fileName
     * @param path
     */
    public void download(String fileName, String path);


    /**
     * 保存自测输入输出数据
     * @param test
     * @throws IOException
     */
    public void saveTestData(Test test) throws IOException;

}
