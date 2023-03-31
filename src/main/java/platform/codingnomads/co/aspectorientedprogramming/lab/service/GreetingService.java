package platform.codingnomads.co.aspectorientedprogramming.lab.service;

import org.springframework.stereotype.Service;
import platform.codingnomads.co.aspectorientedprogramming.lab.aspect.Printable;

@Service
public class GreetingService {

    public String greeting() {
        return "Hello Spring Developer!";
    }

    @Printable(value = "this is our printable Annotation")
    public String hwMethod() {
        return "this is for AOP Assignment";
    }

}
