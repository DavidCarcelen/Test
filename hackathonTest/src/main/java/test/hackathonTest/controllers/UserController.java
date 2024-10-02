package test.hackathonTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody UserDTO userDTO){
        userService.updateUser(userDTO);
        return ResponseEntity.ok("user updated");
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestBody String email){
        userService.deleteUser(email);
        return ResponseEntity.ok("user deleted");
    }

    @GetMapping("/getUser")
    public UserDTO getUser(@RequestBody String email){
        UserDTO userDTO = userService.getUser(email);
        return userDTO;
    }

}
