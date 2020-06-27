package com.hqz.hzuoj.common;


import com.hqz.hzuoj.common.exception.enums.ErrorEnum;
import io.swagger.models.auth.In;
import lombok.Data;

import java.util.HashMap;

/**
 *
 */
@Data
public class R {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 消息
     */
    private String message;
    /**
     * 数据
     */
    private Object data;

    public R() {
        this.code = 200;
        this.message = "";
    }

    public R(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功
     * @param message
     * @param data
     * @return
     */
    public static R ok(String message, Object data) {
        R r = new R();
        r.setMessage(message);
        r.setData(data);
        return r;
    }

    /**
     * 成功
     * @param message
     * @return
     */
    public static R ok(String message) {
        R r = new R();
        r.setCode(200);
        r.setMessage(message);
        return r;
    }

    /**
     * 错误
     * @param message
     * @return
     */
    public static R error(String message) {
        R r = new R();
        r.setCode(0);
        r.setMessage(message);
        return r;
    }


    /**
     * 错误
     * @param code
     * @param message
     * @return
     */
    public static R error(Integer code, String message) {
        R r = new R();
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

    public static R exception() {
        return exception(ErrorEnum.UNKNOWN);
    }

    /**
     * 异常
     * @param eEnum
     * @return
     */
    public static R exception(ErrorEnum eEnum) {
        return R.error(eEnum.getCode(), eEnum.getMessage());
    }

}
