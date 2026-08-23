package com.lughtech.endpoint_metrics.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {

    private final Logger logger = LoggerFactory.getLogger("LogginAspect");

    @Pointcut("execution(* com.lughtech.endpoint_metrics..*Controller.*(..))")
    public void controllerMethods() {

    }

    @Around("controllerMethods()")
    public Object logExecutionDetails(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        String method = joinPoint.getSignature().toShortString();
        logger.info("Entering: {}", method );
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - startTime;
        logger.info("Exiting: {} executed in {}ms", method, duration);
        if(duration > 2500) {
            logger.warn("Method {} execution time is greather than 2500ms", method);
        }
        return result;
    }
    
}
