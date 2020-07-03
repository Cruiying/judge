package com.hqz.hzuoj.common.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
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
    @Value("${judgeOutputPath}")
    public String judgeOutputPath;
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

    /**
     * 自测输出输出文件存放路径
     */
    @Value("${judgeTestPath}")
    public String judgeTestPath;

}
