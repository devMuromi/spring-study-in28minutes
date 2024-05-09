package com.devmuromi.learnspringaop.acpects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    // @Before: 메소드가 호출되기 전에 실행
    @Before("execution(* com.devmuromi.learnspringaop.aopexample.*.*.*(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        logger.info("Before Aspect - Method is called - {} is called with arguments: {}", joinPoint, joinPoint.getArgs());
    }
}
