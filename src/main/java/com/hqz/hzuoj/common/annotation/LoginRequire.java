package com.hqz.hzuoj.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
* @ClassName: LoginRequire
* @Description: 检查是否登录注解（在controller的方法上使用此注解，该方法在被调用时会检查是否已登录）
* @author chenliqiao
* @date 2017年9月19日 上午8:57:32
*
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequire {
}
