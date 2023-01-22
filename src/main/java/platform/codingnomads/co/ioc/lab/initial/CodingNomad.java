package platform.codingnomads.co.ioc.lab.initial;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;


    @Component
    @RequiredArgsConstructor
    public class CodingNomad {

        private final laptop laptop;
        private final JDK jdk;
        private final IDE ide;
        private final Framework framework;
        private final laptopSetup laptopSetup;
        public String createAwesomeSoftware() {
            return MessageFormat
                    .format("This coding nomad is creating awesome software using, " +
                                    "LaptopSetup: ({0}:({1}:{2}) GB of Ram)  , IDEA: ({3}:{4}), JDK: ({5}:{6}), Framework:({7}:({8}),;",
                            laptopSetup.getLaptop(),
                            laptop.getBrand(),
                            laptop.getRam(),
                            ide.getName(),
                            ide.getVersion(),
                            jdk.getName(),
                            jdk.getVersion(),
                            framework.getName(),
                            framework.getVersion()




                    );
        }
    }

