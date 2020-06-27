package com.hqz.hzuoj.common.exception;

import com.hqz.hzuoj.common.exception.enums.ErrorEnum;
import lombok.Data;

/**
 * MyException
 *
 * @author Cruiying
 * @date 2018/10/07 13:54
 * @email 2322144259@qq.com
 * @description 自定义异常
 */

public class MyException extends RuntimeException{
    private String msg;
    private int code = 500;

    public MyException(){
        super(ErrorEnum.UNKNOWN.getMessage());
        this.msg=ErrorEnum.UNKNOWN.getMessage();
    }


    public MyException(ErrorEnum eEnum,Throwable e){
        super(eEnum.getMessage(),e);
        this.msg=eEnum.getMessage();
        this.code=eEnum.getCode();
    }

    public MyException(ErrorEnum eEnum){
        this.msg=eEnum.getMessage();
        this.code=eEnum.getCode();
    }

    public MyException(String exception){
       this.msg=exception;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
