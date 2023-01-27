package platform.codingnomads.co.corespring.examples.dependsonannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class DependsOnDemoConfig {

    @Bean
    @DependsOn(value = "jdk")
    public NewDEV springDeveloper() {
        return new NewDEV();
    }
    @Bean
    @DependsOn(value = "jdk")
    public SpringDeveloper springDeveloper2(){return new SpringDeveloper();}

    @Bean("jdk")
    public JDK jdk() {
        return new JDK();
    }
}
