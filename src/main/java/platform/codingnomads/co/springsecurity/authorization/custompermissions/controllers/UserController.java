package platform.codingnomads.co.springsecurity.authorization.custompermissions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import platform.codingnomads.co.springsecurity.authorization.custompermissions.config.GlobalExceptionHandler;
import platform.codingnomads.co.springsecurity.authorization.custompermissions.models.User;
import platform.codingnomads.co.springsecurity.authorization.custompermissions.services.UserService;
import platform.codingnomads.co.springsecurity.recipeapi.security.CustomPermissionEvaluator;

import javax.annotation.security.RolesAllowed;

@Controller
public class UserController  extends GlobalExceptionHandler {

    @Autowired
    UserService userService;


    @GetMapping("/")
    public String home() {
        return "permissions";
    }

    @GetMapping("/user")
    @ResponseBody
    @PostAuthorize("hasPermission(returnObject, 'READ')")
    public User getEntityById(@RequestParam String email) {
        return userService.getUser(email);
    }

    @GetMapping("/user/delete/{id}")
    @ResponseBody
    @PreAuthorize("hasPermission(#id, 'platform.codingnomads.co.springsecurity.authorization.custompermissions.models.User', 'DELETE')")
    public String deleteEntity(@PathVariable Long id) {
        userService.deleteUser(id);
        return ("deleted user with id: " + id);
    }
   @PostMapping("user/post/{email}")

    @ResponseBody
    @PreAuthorize("hasPermission(#email,'platform.codingnomads.co.springsecurity.authorization.custompermissions.models.User', 'POST')")
            public String changeEmail(@PathVariable String email){
        userService.changeEmail(email);
        return("changed email with" + email);
   }
   @GetMapping("/user/email")
    @ResponseBody

 @PostAuthorize("hasPermission(returnObject, 'READ')")
    public User getUserByEmail(@RequestParam String email){return userService.getUser("is this your email" + email);}


}
