package test.hackathonTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test.hackathonTest.model.domain.Activity;
import test.hackathonTest.model.dto.ActivityDTO;
import test.hackathonTest.model.services.ActivityService;

@RestController
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @PutMapping("/newActivity")
    public ResponseEntity<String> newActivity (@RequestBody ActivityDTO activityDTO){
        activityService.newActivity(activityDTO);
        return ResponseEntity.ok("new activity created");
    }
}
