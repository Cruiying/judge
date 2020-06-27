package com.hqz.hzuoj.common.enums;

/**
 * 题目枚举类型
 */

public enum  ProblemEnum {
    /**
     * 题目公共（所有人可见）
     */
    PUBLIC_CODE_PUBLIC("PUBLIC_CODE_PUBLIC", "题目公共（所有人可见）"),

    /**
     * 比赛可见
     */
    PUBLIC_CODE_CONTEST("PUBLIC_CODE_CONTEST", "比赛可见"),

    /**
     * 管理员可见
     */
    PUBLIC_CODE_ADMIN("PUBLIC_CODE_ADMIN", "管理员可见");

    private final String code;

    private final String message;

    ProblemEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return "ProblemEnum{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
