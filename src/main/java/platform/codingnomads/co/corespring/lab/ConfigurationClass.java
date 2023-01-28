package platform.codingnomads.co.corespring.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:xml-config/Netflix.xml"})

public class ConfigurationClass {
    @Bean
 public TV tv(){return new  TV("Toshiba",2018) ;}

}
