package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrintableAspect {
    @Pointcut("@annotation(platform.codingnomads.co.aspectorientedprogramming.lab.annotations.Printable)")
    public void printableAnnotation() {
    }


    private static final Logger LOGGER = LoggerFactory.getLogger(PrintableAspect.class);

    @Pointcut("@annotation(platform.codingnomads.co.aspectorientedprogramming.lab.annotations.Printable)")
    public void printableMethods() {}

    @Before("printableMethods()")
    public void beforePrintableMethods() {
        LOGGER.info("Executing a method annotated with @Printable");
        System.out.println("This method is printable!");
    }
}

