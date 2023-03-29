package platform.codingnomads.co.aspectorientedprogramming.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class TrackTimeElapsed {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TrackTimeElapsed.class);

   @Around("@annotation(TimeElapsed)")
    public Object around(@NonNull ProceedingJoinPoint joinPoint) throws Throwable{
       long start = System.currentTimeMillis();
       Object totalTime = joinPoint.proceed();
       long endTime = System.currentTimeMillis() - start;
       LOGGER.info("Execution time of method {} is {} ms", joinPoint.getSignature().getName(), endTime);

       return totalTime;
   }
}
