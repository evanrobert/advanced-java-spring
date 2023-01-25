package platform.codingnomads.co.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component("sharpImages")
@ToString
public class SharpImages implements GraphicsCard{
}
