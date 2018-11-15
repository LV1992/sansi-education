package com.sansi.education.user.configuration.aop;

import com.google.common.base.Strings;
import com.sansi.education.common.BaseEnterDto;
import com.sansi.education.enums.BaseException;
import com.sansi.education.exceptions.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoginCheckInterceptor {

    @Pointcut("execution(* com.sansi.education.user.service..*.*(..))")
    public void checkPoint(){}

    @Around("checkPoint()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取拦截方法的参数,默认去第一个
        Object arg = joinPoint.getArgs()[0];
        //没有继承BaseEnterDto 则不校验sessionKey
        if (!(arg instanceof BaseEnterDto)){
            return joinPoint.proceed();
        }
        //校验sessionKey
        BaseEnterDto baseEnterDto = (BaseEnterDto) arg;
        if(Strings.isNullOrEmpty(baseEnterDto.getSessionKey())){
            throw new BusinessException(BaseException.LOGIN_EXPIRE.getCode(),BaseException.LOGIN_EXPIRE.getMsg());
        }
        return joinPoint.proceed();
    }
}
