package platform.codingnomads.co.corespring.examples.beanscopes.prototype;

import lombok.*;
import org.apache.ibatis.annotations.ConstructorArgs;



public class SpringBean {
    public SpringBean() {
        System.out.println("-----Hey, I'm a Spring bean, not a String bean!-----");

    }
    public static class SpringBeanNew{


            public SpringBeanNew() {


                System.out.println(" This is a new Spring Bean ");
            }



    }
}




















