package platform.codingnomads.co.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component("megaGraphics")
@ToString
public class MegaGraphics implements GraphicsCard{
}
