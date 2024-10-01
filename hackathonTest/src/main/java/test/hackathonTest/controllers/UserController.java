package test.hackathonTest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test.hackathonTest.model.dto.UserDTO;

@RestController
public class UserController {
    @PutMapping("/newUser")
    public ResponseEntity<String> newUser(@RequestBody UserDTO userDTO){

    }
}
