package platform.codingnomads.co.corespring.examples.beanscopes.prototype;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ProtoTypeDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(PrototypeDemoConfig.class);
        ctx.refresh();


        SpringBean springBean1 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code: " + springBean1.hashCode());

        SpringBean springBean2 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code: " + springBean2.hashCode());


        SpringBean.SpringBeanNew springBeanNew = ctx.getBean(SpringBean.SpringBeanNew.class);
        System.out.println("hash code " + springBeanNew.hashCode());
        SpringBean.SpringBeanNew springBeanNew22 = ctx.getBean(SpringBean.SpringBeanNew.class);
        System.out.println("hash code " + springBeanNew22.hashCode() + springBeanNew22.name);












        ctx.close();

    }
}
