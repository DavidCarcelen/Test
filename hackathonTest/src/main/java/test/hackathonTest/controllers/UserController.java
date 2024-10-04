package test.hackathonTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.hackathonTest.model.dto.UserDTO;
import test.hackathonTest.model.services.ActivityService;
import test.hackathonTest.model.services.UserService;

@RestController
@RequestMapping("/activityApp/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ActivityService activityService;
    @PostMapping
    public ResponseEntity<String> newUser(@RequestBody UserDTO userDTO){
        userService.newUser(userDTO);
        return ResponseEntity.ok("user created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable long id, @RequestBody UserDTO userDTO){
        userService.updateUser(id, userDTO);
        return ResponseEntity.ok("user updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("user deleted");
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable long id){
        UserDTO userDTO = userService.getUser(id);
        return userDTO;
    }

    @PutMapping("/signup/{idUser}/{idActivity}")
    public ResponseEntity<String> signUpForActivity(@PathVariable long idUser, @PathVariable long idActivity){
        userService.signUp(idUser, idActivity);
        return ResponseEntity.ok("user signed up for activity");
    }

}
