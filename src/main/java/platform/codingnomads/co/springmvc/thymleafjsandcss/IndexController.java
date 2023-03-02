package platform.codingnomads.co.springmvc.thymleafjsandcss;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping(value = "/")
    public String index() {
        return "thymeleaf-include-js-css";
    }

    @GetMapping(value = "/practice")
    public String index2(){return "thymeleaf-include-js-css";}
}

