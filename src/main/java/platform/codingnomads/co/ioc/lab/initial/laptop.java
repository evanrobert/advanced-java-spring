package platform.codingnomads.co.ioc.lab.initial;

import groovy.transform.Field;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor



public class laptop {
   @Setter String Brand;
    int size;
    int ram;

}
