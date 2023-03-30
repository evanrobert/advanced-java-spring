package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import platform.codingnomads.co.aspectorientedprogramming.aop.aspect.LoggingAspect;
import platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService;

import java.util.Arrays;

@Aspect
@Component
public class GreetingServiceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingServiceAspect.class);

    @Pointcut(value = "execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.greeting(..))")
    public void logMethod() {
    }

    @Before("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.greeting())")
    public void beforeGreeting(JoinPoint joinPoint) {
        System.out.println("Before greeting() - " + joinPoint.getSignature().getName() +  " is being called");
    }

    @AfterReturning(pointcut = "execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.greeting())", returning = "result")
    public void afterGreeting(JoinPoint joinPoint, Object result) {
        System.out.println("After greeting() - " + joinPoint.getSignature().getName() + " is being called");
        System.out.println("Returned value: " + result);
    }
    @Pointcut(value = "execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.hwMethod(..))")
    public void hwAssignment() {
    }
    @Before("hwAssignment()")
    public void beforeHwMethod(JoinPoint joinPoint) {
        LOGGER.info("Before executing hwMethod()");
    }

}





//    Write an Aspect in the GreetingServiceAspect class which will target the execution of
//    the greeting() method before and after its execution.
//
//        Print "Before" in the console when @Before advice will run.
//
//        Print "After Returning" when @AfterReturning advice will run.
//
//        Add a second method to the GreetingService class.
//
//        Inside GreetingServiceAspect, create a Pointcut that references this new method.
//
//        Inside GreetingServiceAspect, create an Advice that references the Pointcut defined above.
//
//        Create a new custom annotation called "Printable".
//
//        Create a new Aspect class called PrintableAspect.
//
//        In this new Aspect define a Pointcut that references your new annotation.
//
//        Create an Advice that references this new Pointcut, which simply prints a String to the console.
//
//        Annotate the second method in your GreetingService class with your new annotation, and ensure that it is triggered as expected.
