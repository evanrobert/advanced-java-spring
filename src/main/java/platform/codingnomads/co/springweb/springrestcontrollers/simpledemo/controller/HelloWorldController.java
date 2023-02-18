package platform.codingnomads.co.springweb.springrestcontrollers.simpledemo.controller;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class HelloWorldController {

    @RequestMapping(path = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        return "Hello Spring Developer!";
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String greeting(@PathVariable(name = "name") String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        return list;
    }
















    }















