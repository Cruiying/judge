package com.hqz.hzuoj.service.impl;


import com.hqz.hzuoj.entity.DTO.SysUserTokenDTO;
import com.hqz.hzuoj.service.ShiroService;
import com.hqz.hzuoj.service.SysUserTokenService;
import com.hqz.hzuoj.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ShiroServiceImpl
 *
 * @author Cruiying
 * @date 2018/10/08 19:58
 * @email 2322144259@qq.com
 * @description Shiro Service实现类
 */
@Service
public class ShiroServiceImpl implements ShiroService {

    @Resource
    private UserService userService;


    @Resource
    private SysUserTokenService sysUserTokenService;

    /**
     * 获取用户的所有权限
     *
     * @param userId
     * @return
     */
    @Override
    public Set<String> getUserPermissions(Integer userId) {
        //系统管理员，拥有最高权限
        /**
         * 获取用户权限
         */
        List<String>  permsList = null;

        //返回用户权限列表
        return permsList.stream()
                // 过滤空置的字符串
                .filter(perms -> !StringUtils.isEmpty(perms))
                // 把小的list合并成大的list
                .flatMap(perms -> Arrays.stream(perms.split(",")))
                // 转换成set集合
                .collect(Collectors.toSet());
    }

    /**
     * 查询token
     *
     * @param token
     * @return
     */
    @Override
    public SysUserTokenDTO queryByToken(String token) {
        return sysUserTokenService.queryByToken(token);
    }

    /**
     * 续期
     *
     * @param userId
     * @param accessToken
     */
    @Override
    public void refreshToken(Integer userId, String accessToken) {
        sysUserTokenService.refreshToken(userId, accessToken);
    }
}
