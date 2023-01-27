package platform.codingnomads.co.corespring.examples.propertysourceannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class mypracticeapp {
    @Value("${my.name}")
    private String myName;

    @Value("${my.age}")
    private String myAge;

    public String getMyName() {
        return myName;
    }

    public String getMyAge() {
        return myAge;
    }
}
