package platform.codingnomads.co.corespring.lab;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import platform.codingnomads.co.corespring.lab.complete.CoreLabConfig;
import platform.codingnomads.co.corespring.lab.complete.Record;

@SpringBootApplication
public class CoreLabApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurationClass.class);
        TV tv = ctx.getBean(TV.class);
        System.out.println("Lets watch some movies on my " + tv.getModelYear() + " " + tv.getMake() + " flat screen TV ");

        String[] netflix = ctx.getBeanNamesForType(Netflix.class);

        for (String net : netflix) {
            System.out.println(" Now Watching " + ctx.getBean(net, Netflix.class).getName()
                    + " The Genre is " + ctx.getBean(net, Netflix.class).getValue() + ".");
        }

        System.out.println("Done for the day!");
    }
}





