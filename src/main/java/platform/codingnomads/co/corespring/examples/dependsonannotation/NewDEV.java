package platform.codingnomads.co.corespring.examples.dependsonannotation;

import org.springframework.beans.factory.annotation.Autowired;

public class NewDEV {
    @Autowired
    private JDK jdk;
    public NewDEV(){
        System.out.println("new dev is ready");
}
    }
