package com.hqz.hzuoj.common.mq.aspect;


import com.hqz.hzuoj.common.constants.RabbitMqConstants;
import com.hqz.hzuoj.common.mq.annotation.RefreshEsMqSender;
import com.hqz.hzuoj.common.util.RabbitMqUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * RefreshEsMqAspect
 *
 * @author Cruiying
 * @date 2019/03/16 22:53
 * @email 2322144259@qq.com
 * @description
 */
@Aspect
@Component
public class RefreshEsMqAspect {


}
