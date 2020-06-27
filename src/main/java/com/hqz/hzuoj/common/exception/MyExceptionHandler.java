package com.hqz.hzuoj.common.exception;


import com.hqz.hzuoj.common.R;
import com.hqz.hzuoj.common.exception.enums.ErrorEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

/**
 * MyExceptionHandler
 *
 * @author Cruiying
 * @date 2018/10/07 14:33
 * @email 2322144259@qq.com
 * @description 统一异常处理器
 */
@RestControllerAdvice
@Slf4j
public class MyExceptionHandler {

    /**
     * 处理自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MyException.class)
    public R handleMyException(MyException e) {
        R r = new R();
        r.setCode(e.getCode());
        r.setMessage(e.getMsg());
        log.error(e.getMsg(),e);
        return r;
    }

    /**
     * 404错误
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public R handlerNoFoundException(Exception e) {
        log.error(e.getMessage(),e);
        return R.exception(ErrorEnum.PATH_NOT_FOUND);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public R handleDuplicateKeyException(DuplicateKeyException e) {
        log.error(e.getMessage(),e);
        return R.exception(ErrorEnum.DUPLICATE_KEY);
    }

    @ExceptionHandler(AuthorizationException.class)
    public R handleAuthorizationException(AuthorizationException e) {
        log.error(e.getMessage(),e);
        return R.exception(ErrorEnum.NO_AUTH);
    }

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        System.err.println(e.getMessage());
        log.error(e.getMessage(),e);
        return R.exception();
    }
}
