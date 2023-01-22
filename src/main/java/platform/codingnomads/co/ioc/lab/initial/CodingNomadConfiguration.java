package platform.codingnomads.co.ioc.lab.initial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
    @ComponentScan("platform.codingnomads.co.ioc.lab.initial")
    public class CodingNomadConfiguration {

        @Bean
        public Framework framework() {
            return Framework.builder().name("Spring Boot").version("2.5").build();
        }

        @Bean
        public IDE ide() {
            return IDE.builder().name("IntelliJ IDEA").version("2021.1").build();
        }

        @Bean
        public JDK jdk() {
            return JDK.builder().name("OpenJDK").version("11").build();
        }
        @Bean
        public laptop laptop(){return laptop.builder().Brand("macbook").ram(16).size(14).build();}

    @Bean
   public laptopSetup laptopSetup(){return laptopSetup.builder().laptop(" The best laptop").ide(" Awesome intellij").build();}
    }

