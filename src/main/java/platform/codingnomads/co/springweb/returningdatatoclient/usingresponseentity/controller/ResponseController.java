package platform.codingnomads.co.springweb.returningdatatoclient.usingresponseentity.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import platform.codingnomads.co.springweb.returningdatatoclient.usingresponseentity.model.User;

import java.net.URI;

@RestController
public class ResponseController {

    User user = new User(1, "Test User", "test@email.com");
    User user2 = new User(5,"Bill","Bill@gmail");


    @GetMapping("/constructor/practice")
    public ResponseEntity<User> constructorMethod() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("TEST", "TEST HEADER");
        headers.add("Location", "/users/" + user.getId());
        return new ResponseEntity<>(user, headers, HttpStatus.CREATED);
    }
    @GetMapping("/demo")
    User getUser(){
        return user;
    }
   @GetMapping("/demo2")

    public ResponseEntity<User> addUser(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("adding USER","TEST"+ user2.getId());
        return  new ResponseEntity<>(user2,httpHeaders,HttpStatus.CREATED);


    }
    @GetMapping("/link/user")
    public ResponseEntity<User> construct(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("HEADER V1","HEADER version 1" + user.getName());
       // return  new ResponseEntity<>(user,headers,HttpStatus.ACCEPTED);
        return  new ResponseEntity<>(user, headers,HttpStatus.FORBIDDEN);
    }

    @GetMapping("/builder")
    public ResponseEntity<User> builderMethod() {
        return ResponseEntity.created(URI.create("/users/" + user.getId()))
                .header("TEST", "TEST HEADER")
                .body(user);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        if (user.getId() == id ) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }


    }
}
