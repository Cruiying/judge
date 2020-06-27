package com.hqz.hzuoj.config.shiro;


import com.hqz.hzuoj.entity.DTO.SysUserTokenDTO;
import com.hqz.hzuoj.entity.model.User;
import com.hqz.hzuoj.service.ShiroService;
import com.hqz.hzuoj.service.SysUserTokenService;
import com.hqz.hzuoj.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;


@Component
public class CustomRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private ShiroService shiroService;

    @Resource
    private SysUserTokenService sysUserTokenService;


    /**
     * 必须重写此方法，不然会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("————身份认证方法————");
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        SysUserTokenDTO sysUserTokenDTO = shiroService.queryByToken(token);
//        System.err.println(token);
//        System.err.println(sysUserTokenDTO);
        if (sysUserTokenDTO == null || !sysUserTokenService.verify(sysUserTokenDTO.getToken(), sysUserTokenDTO.getUserId())) {
            throw new AuthenticationException("token认证失败！");
        }
        User user = userService.queryById(sysUserTokenDTO.getUserId());
        if (user == null) {
            throw new AuthenticationException("该用户不存在！");
        }
        if (!user.getStatus()) {
            throw new AuthenticationException("该用户已被封号！");
        }
        return new SimpleAuthenticationInfo(token, token, getName());
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("————权限认证————");
        String username = "Cruiying";
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        String role = "项目经理";
        //每个角色拥有默认的权限
        String rolePermission = "f";
        //每个用户可以设置新的权限
        String permission = "bi";
        Set<String> roleSet = new HashSet<>();
        Set<String> permissionSet = new HashSet<>();
        //需要将 role, permission 封装到 Set 作为 info.setRoles(), info.setStringPermissions() 的参数
        roleSet.add(role);
        permissionSet.add(rolePermission);
        permissionSet.add(permission);
        //设置该用户拥有的角色和权限
        info.setRoles(roleSet);
        info.setStringPermissions(permissionSet);
        return info;
    }
}
