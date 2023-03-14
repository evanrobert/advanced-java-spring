package platform.codingnomads.co.springtest.usingmockmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Bobbert");
        return "greeting";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String greet() {
        return "Hello Back";

    }

    @GetMapping("/hey")
    public String greetings(Model  model) {
model.addAttribute("name","evan");
        return "greeting2";

    }
    @GetMapping("/Hello")
    @ResponseBody
    public int maths(int a, int b){

        return a * b;
    }
    @GetMapping("/warning")
    public String warning(Model model){
        model.addAttribute("name","Warning");
        return "greeting2";
    }
}
