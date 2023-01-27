package platform.codingnomads.co.corespring.examples.profileannotation;

import lombok.Getter;
import lombok.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Value
public class SpringDeveloper {
    public SpringDeveloper() {
        System.out.println("SpringDeveloper is ready.");
    }


    }


