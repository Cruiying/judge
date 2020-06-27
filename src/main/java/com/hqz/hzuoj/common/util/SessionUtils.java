package com.hqz.hzuoj.common.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class SessionUtils {

    public static void set(String key,Object o){
        Subject subject= SecurityUtils.getSubject();
        subject.getSession().setAttribute(key,o);
    }

    public static <T> T get(String key){
        Subject subject= SecurityUtils.getSubject();
        return (T) subject.getSession().getAttribute(key);
    }
}
