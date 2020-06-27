package com.hqz.hzuoj.common.constants;

/**
 * RedisKeyConstants
 *
 * @author Cruiying
 * @date 2018/10/20 13:44
 * @email 2322144259@qq.com
 * @description redis baseKey管理常量
 */
public class RedisKeyConstants {


    /**
     * 前台用户token
     */
    public final static String SYS_USER_TOKEN = "SYS:USER:TOKEN:";

    /**
     * 后台管理员token
     */
    public final static String SYS_ADMIN_TOKEN = "SYS:ADMIN:TOKEN:";

    /**
     * 验证码key
     */
    public final static String MANAGE_SYS_CAPTCHA = "MANAGE:SYS:CAPTCHA:";

    /**
     * 验证码
     */
    public final static String SYS_CAPTCHA = "SYS:CAPTCHA";

    /**
     * token过期时间 5 天
     */

    public static final int TOKEN_EXPIRE_TIME = 60 * 24 * 60 * 1000 * 5;
    /**
     * token密钥
     */
    public static final String TOKEN_SECRET_KEY = "SHIRO+JWT";

}
