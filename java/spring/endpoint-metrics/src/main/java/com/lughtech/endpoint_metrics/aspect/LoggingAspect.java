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
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.lughtech.endpoint_metrics..*Controller.*(..))")
    public void controllerMethods() {

    }

    @Around("controllerMethods()")
    public Object logExecutionDetails(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();
        String method = joinPoint.getSignature().toShortString();
        logger.info("Entering: {}", method);
        try {
            return joinPoint.proceed();
        } catch (Throwable exception) {
            logger.error("Failed: {}", method, exception);
            throw exception;
        } finally {
            long duration = (System.nanoTime() - startTime) / 1_000_000;
            logger.info("Exiting: {} executed in {}ms", method, duration);
            if (duration >= 2500) {
                logger.warn("Method {} execution time is greater than or equal to 2500ms", method);
            }
        }
    }
    
}
