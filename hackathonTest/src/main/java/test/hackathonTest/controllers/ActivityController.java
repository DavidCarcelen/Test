package test.hackathonTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.hackathonTest.model.domain.Activity;
import test.hackathonTest.model.dto.ActivityDTO;
import test.hackathonTest.model.services.ActivityService;

@RestController
@RequestMapping("/activityApp/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @PostMapping
    public ResponseEntity<String> newActivity (@RequestBody ActivityDTO activityDTO){
        activityService.newActivity(activityDTO);
        return ResponseEntity.ok("new activity created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateActivity (@PathVariable long id, @RequestBody ActivityDTO activityDTO){
        activityService.updateActivity(id, activityDTO);
        return ResponseEntity.ok("activity updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteActivity (@PathVariable long id){
        activityService.deleteActivity(id);
        return ResponseEntity.ok("activity deleted");
    }
}
