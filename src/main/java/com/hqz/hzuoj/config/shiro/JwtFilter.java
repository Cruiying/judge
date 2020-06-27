package com.hqz.hzuoj.config.shiro;


import com.hqz.hzuoj.common.constants.RedisKeyConstants;
import com.hqz.hzuoj.common.util.CookieUtil;
import com.hqz.hzuoj.common.util.SessionUtils;
import com.hqz.hzuoj.entity.DTO.SysUserTokenDTO;
import com.hqz.hzuoj.entity.model.User;
import com.hqz.hzuoj.service.ShiroService;
import com.hqz.hzuoj.service.SysUserTokenService;
import com.hqz.hzuoj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
public class JwtFilter extends BasicHttpAuthenticationFilter {

    @Autowired
    private ShiroService shiroService;

    @Autowired
    private UserService userService;

    @Autowired
    private SysUserTokenService sysUserTokenService;

    /**
     * 如果带有 token，则对 token 进行检查，否则直接通过
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws UnauthorizedException {
//        System.err.println("KKK:" + mappedValue);
        System.err.println("过滤");
        //判断请求的请求头是否带上 "userToken"
        if (isLoginAttempt(request, response)) {
            System.err.println("成功");
            //如果存在，则进入 executeLogin 方法执行登入，检查 token 是否正确
            try {
                executeLogin(request, response);
                return true;
            } catch (Exception e) {
//                e.printStackTrace();
                log.error(e.getMessage());
                return true;
            }
        }
        //如果请求头不存在 Token，则可能是执行登陆操作或者是游客状态访问，无需检查 token，直接返回 true
        return true;
    }

    /**
     * 判断用户是否想要登入。
     * 检测 Cookie 里面是否包含 token 字段
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = null;
        String cookieToken = CookieUtil.getCookieValue(req, "userToken", true);
//        System.err.println("cookieToken:"+cookieToken);
        if (StringUtils.isNotBlank(cookieToken)) {
            token = cookieToken;
        }
        String requestToken = request.getParameter("userToken");
//        System.err.println("requestToken:" + requestToken);
        if (StringUtils.isNotBlank(requestToken)) {
            token = requestToken;
        }
        return StringUtils.isNotBlank(token);
    }


    /**
     * 执行登陆操作
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String token = null;
        String cookieToken = CookieUtil.getCookieValue(httpServletRequest, "userToken", true);
        if (StringUtils.isNotBlank(cookieToken)) {
            token = cookieToken;
        }
        String requestToken = request.getParameter("userToken");
        if (StringUtils.isNotBlank(requestToken)) {
            token = requestToken;
        }
//        System.err.println("shiroService:" + shiroService);
//        System.err.println("userService:" + userService);
        SysUserTokenDTO sysUserTokenDTO = shiroService.queryByToken(token);
        if (sysUserTokenDTO == null) {
            //redis登录过期
            return false;
        }
        User user = userService.queryById(sysUserTokenDTO.getUserId());
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        JwtToken jwtToken = new JwtToken(token);
        getSubject(request, response).login(jwtToken);
        CookieUtil.setCookie(httpServletRequest, httpServletResponse, "userToken", token, RedisKeyConstants.TOKEN_EXPIRE_TIME, true);
        SessionUtils.set("user", user);
        // 如果没有抛出异常则代表登入成功，返回true
        return true;
    }

    /**
     * 对跨域提供支持
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }
}
