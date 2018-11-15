package com.sansi.education.web.configuration;

import com.sansi.education.common.Response;
import com.sansi.education.enums.BaseException;
import com.sansi.education.exceptions.BusinessException;
import com.sansi.education.web.utils.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ip拦截
 * <p>
 * execution（） 表达式的主体；
 * 第一个”*“符号 表示返回值的类型任意；
 * com.sample.service.impl	AOP所切的服务的包名，即，我们的业务部分
 * 包名后面的”..“	表示当前包及子包
 * 第二个”*“	表示类名，*即所有类。此处可以自定义，下文有举例
 * .*(..)	表示任何方法名，括号表示参数，两个点表示任何参数类型
 *
 * @author yihang.lv 2018/8/22、17:06
 */
@Slf4j
@Aspect
@Component
public class IpAspect {

    @Autowired
    private IpUtil ipUtil;

    //设置切点(所有接口拦截)
    @Pointcut("execution(* com.sansi.education.web.controller..*.*(..))")
    public void controllerPointCut() {
    }

    @Around("controllerPointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String ip = ipUtil.getIp();
        log.info("current methodName is {} : ip is {}", methodName, ip);
        checkIp(ip);
        //执行方法，返回结果
        Object res = joinPoint.proceed();
        if (res instanceof Response) {
            Response response = (Response) res;
            response.setRequestIp(ip);
            return response;
        }
        return res;
    }

    private void checkIp(String ip) {
        if ("192.168.56.1".equals(ip)) {
            throw new BusinessException(BaseException.LIMITED_IP_LIST.getCode(), BaseException.LIMITED_IP_LIST.getMsg());
        }
    }

}
