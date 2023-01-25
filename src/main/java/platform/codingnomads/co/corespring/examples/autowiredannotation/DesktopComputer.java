package platform.codingnomads.co.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@ToString
public class DesktopComputer {

    @Autowired (required = false)
    @Qualifier("radeon")
    private VideoCard videoCard;
    @Autowired (required = false)
    @Qualifier("megaGraphics")
    private GraphicsCard graphicsCard;

}
