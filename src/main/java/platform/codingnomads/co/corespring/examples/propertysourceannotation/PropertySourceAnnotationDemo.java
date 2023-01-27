package platform.codingnomads.co.corespring.examples.propertysourceannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertySourceAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(PropertySourceAnnotationConfig.class);
        ctx.refresh();
        final mypracticeapp mypracticeapp = ctx.getBean(mypracticeapp.class);
        System.out.println("Values from myapp.properties: " +
                "My Name: " + mypracticeapp.getMyName() + ", My Age: " + mypracticeapp.getMyAge());
        ctx.close();
    }
}
