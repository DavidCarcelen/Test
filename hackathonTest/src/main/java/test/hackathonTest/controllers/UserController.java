package test.hackathonTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test.hackathonTest.model.dto.UserDTO;
import test.hackathonTest.model.services.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @PutMapping("/newUser")
    public ResponseEntity<String> newUser(@RequestBody UserDTO userDTO){
        userService.newUser(userDTO);
        return ResponseEntity.ok("user created");
    }
}
