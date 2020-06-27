package com.hqz.hzuoj.service.impl;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hqz.hzuoj.common.constants.RedisKeyConstants;
import com.hqz.hzuoj.common.util.RedisUtil;
import com.hqz.hzuoj.entity.DTO.SysUserTokenDTO;
import com.hqz.hzuoj.service.SysUserTokenService;
import com.hqz.hzuoj.service.UserService;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * SysUserTokenServiceImpl
 *
 * @author Cruiying
 * @date 2018/10/20 15:18
 * @email 2322144259@qq.com
 * @description
 */
@Service
@Slf4j
public class SysUserTokenServiceImpl implements SysUserTokenService {

    //30天后过期
    private final static int EXPIRE = 3600 * 24 * 30;

    @Autowired
    private RedisUtil redisUtil;

    @Resource
    private UserService userService;

    /**
     * 生成Token
     *
     * @param userId
     * @return
     */
    @Override
    public String createToken(Integer userId) {
        Date date = new Date(System.currentTimeMillis() + RedisKeyConstants.TOKEN_EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(RedisKeyConstants.TOKEN_SECRET_KEY);
        // 附带userId信息
        String token = JWT.create().withClaim("userId", userId)
                //到期时间
                .withExpiresAt(date)
                //创建一个新的JWT，并使用给定的算法进行标记
                .sign(algorithm);
        this.saveToken(token, userId);
        return token;
    }

    /**
     * 保存用户token到redis
     *
     * @param token
     * @param userId
     * @return
     */
    @Override
    public boolean saveToken(String token, Integer userId) {
        String tokenKey = RedisKeyConstants.SYS_USER_TOKEN + token;
        String userIdKey = RedisKeyConstants.SYS_USER_TOKEN + userId;
        redisUtil.set(tokenKey, userId, RedisKeyConstants.TOKEN_EXPIRE_TIME);
        redisUtil.set(userIdKey, token, RedisKeyConstants.TOKEN_EXPIRE_TIME);
        return true;
    }

    /**
     * 验证token
     *
     * @param token
     * @param userId
     * @return
     */
    @Override
    public boolean verify(String token, Integer userId) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(RedisKeyConstants.TOKEN_SECRET_KEY);
            //在token中附带了username信息
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("userId", userId)
                    .build();
            //验证 token
            verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 查询token
     *
     * @param token
     * @return
     */
    @Override
    public SysUserTokenDTO queryByToken(String token) {
        String tokenKey = RedisKeyConstants.SYS_USER_TOKEN + token;
        Integer userId = (Integer) redisUtil.get(tokenKey);
        String userIdKey = RedisKeyConstants.SYS_USER_TOKEN + userId;
        token = (String)redisUtil.get(userIdKey);
        SysUserTokenDTO sysUserTokenDTO = new SysUserTokenDTO();
        sysUserTokenDTO.setToken(token);
        sysUserTokenDTO.setUserId(userId);
        return sysUserTokenDTO;
    }

    /**
     * 获得token中的信息，无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    @Override
    public String getUsername(String token) {
        try {
            if (token == null) {
                return null;
            }
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asString();
        } catch (JWTDecodeException e) {
            log.error("getUsername({}) error message: {}", token, e.getMessage());
            return null;
        }
    }

    /**
     * 退出登录
     *
     * @param userId
     */
    @Override
    public void logout(Integer userId) {
        String userIdKey = RedisKeyConstants.SYS_USER_TOKEN + userId;
        String token = (String) redisUtil.get(userIdKey);
        String tokenKey = RedisKeyConstants.SYS_USER_TOKEN + token;
        redisUtil.del(userIdKey);
        redisUtil.del(tokenKey);
    }

    /**
     * 登录续期
     *
     * @param userId
     * @param token
     */
    @Override
    public void refreshToken(Integer userId, String token) {
        String userIdKey = RedisKeyConstants.SYS_USER_TOKEN + userId;
        String tokenKey = RedisKeyConstants.SYS_USER_TOKEN + token;
        redisUtil.set(userIdKey, userId, RedisKeyConstants.TOKEN_EXPIRE_TIME);
        redisUtil.set(tokenKey, token, RedisKeyConstants.TOKEN_EXPIRE_TIME);
    }


}
