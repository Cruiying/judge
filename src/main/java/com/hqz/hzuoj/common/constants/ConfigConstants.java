package com.hqz.hzuoj.common.constants;

import org.springframework.beans.factory.annotation.Value;

public class ConfigConstants {

    /**
     * 测评运行exe存放位置
     */
    @Value("${judge}")
    public String judge;
    /**
     * 程序运行输入文件路径
     */
    @Value("${judgeInputPath}")
    public String judgeInputPath;
    /**
     * 程序运行结果输出路径
     */
    @Value("${judgeResultPath}")
    public String judgeResultPath;
    /**
     * 题目上传测试压缩包路径
     */
    @Value("${problemDataPath}")
    public String problemDataPath;
    /**
     * 测试点存放路径
     */
    @Value("${submitCasePath}")
    public String submitCasePath;

}
