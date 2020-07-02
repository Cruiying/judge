package com.hqz.hzuoj.common.enums;

public enum JudgeResultEnum {
    /**
     * 超时
     */
    TLE("Time Limit Exceeded", "TLE", "超时"),
    /**
     * 内存溢出
     */
    MEL("Output Limit Exceeded", "MEL", "内存溢出"),
    /**
     * 正确
     */
    AC("Accepted", "AC", "正确"),
    /**
     * 错误
     */
    WA("Wrong Answer", "WA", "错误"),
    /**
     * 等待
     */
    PD("Pending", "PD", "等待"),
    /**
     * 输出超限
     */
    OLE("Output Limit Exceeded", "OLE", "输出超限"),
    /**
     * 运行错误
     */
    RE("Runtime Error", "RE", "运行错误"),
    /**
     * 编译错误
     */
    CE("Compile Error", "CE", "编译错误"),
    /**
     * 队列中
     */
    QUEUE("Queue", "QUEUE", "队列中"),
    /**
     * 运行中
     */
    RUNNING("Running", "RUNNING", "运行中"),
    /**
     * 编译中
     */
    COMPILE("Compile", "COMPILE", "编译中");

    /**
     * 结果名
     */
    private final String name;
    /**
     * 结果名缩写
     */
    private final String abbr;
    /**
     * 消息
     */
    private final String msg;

    JudgeResultEnum(String name, String abbr, String msg) {
        this.name = name;
        this.abbr = abbr;
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "JudgeResultConstants{" +
                "name='" + name + '\'' +
                ", abbr='" + abbr + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
