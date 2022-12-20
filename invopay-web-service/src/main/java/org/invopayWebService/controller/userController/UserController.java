package org.invopayWebService.controller.userController;

import com.commons.ResponceHandler;
import org.invopayWebService.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.commons.webDTOS.user.UserDTO;

@RestController
public class UserController {

    @Autowired
    private UserService userServices;

    @PostMapping("/register")
    public ResponseEntity<Object> createClient(@RequestBody UserDTO userDTO){
        return ResponceHandler.generateResponce(HttpStatus.OK , true ,userServices.registration(userDTO));
    }

}
