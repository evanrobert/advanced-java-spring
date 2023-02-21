package platform.codingnomads.co.springweb.returningdatatoclient.responsebody.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import platform.codingnomads.co.springweb.returningdatatoclient.responsebody.model.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class UserController {

    public User user = User.builder()
            .id(1000)
            .name("Spring Dev")
            .email("dev@codingnomads.co")
            .build();
    public User user2 = User.builder().id(2000).name("bill").email("billsemail@email.com").build();


    public User user3 = User.builder().id(2500).name("jill").email("jillssemail@email.com").build();
    public User user4 = User.builder().id(3000).name("will").email("willssemail@email.com").build();

    //using ResponseBody to return a POJO
    @ResponseBody
    @GetMapping("/response-body")
    public User userResponseBody() {
        return user;
    }

    //using ResponseEntity to return POJO
    @GetMapping("/response-entity")
    public ResponseEntity<User> userResponseEntity() {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //returning a POJO without ResponseBody or using a ResponseEntity - error expected
    @GetMapping("/user")
    public User user() {
        return user;
    }


    @ResponseBody
    @GetMapping("/user/list")
    public List<User> userList() {
        List<User> users = new ArrayList<>();

        users.add(user2);
        users.add(user3);
        users.add(user4);
        return users;


    }
}