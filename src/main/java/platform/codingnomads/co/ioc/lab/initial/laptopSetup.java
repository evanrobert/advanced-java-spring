package platform.codingnomads.co.ioc.lab.initial;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import platform.codingnomads.co.ioc.examples.setterinjection.Laptop;

@Getter
@Setter
@Builder


public class laptopSetup {
private String laptop;
  private String ide;
    @Autowired
 public laptopSetup(String laptop, String ide){
        this.laptop = laptop;
        this.ide = ide;
    }


}
