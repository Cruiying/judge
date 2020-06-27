package com.hqz.hzuoj.service;


import com.hqz.hzuoj.entity.DTO.SysUserTokenDTO;

/**
 *
 */
public interface SysUserTokenService {
    /**
     * 生成Token
     * @param userId
     * @return
     */
    String createToken(Integer userId);

    /**
     * 保存token
     * @param token
     * @param userId
     * @return
     */
    boolean saveToken(String token, Integer userId);

    /**
     * token验证
     * @param token
     * @param userId
     * @return
     */
    boolean verify(String token, Integer userId);

    /**
     * 查询token
     * @param token
     * @return
     */
    SysUserTokenDTO queryByToken(String token);

    /**
     *
     * @param token
     * @return
     */
    String getUsername(String token);

    /**
     * 退出登录
     * @param userId
     */
    void logout(Integer userId);

    /**
     * 续期
     * @param userId
     * @param token
     */
    void refreshToken(Integer userId, String token);
}
