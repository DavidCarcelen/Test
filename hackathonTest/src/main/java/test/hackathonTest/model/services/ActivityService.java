package test.hackathonTest.model.services;

import test.hackathonTest.model.dto.ActivityDTO;
import test.hackathonTest.model.dto.UserDTO;

public interface ActivityService {
    void newActivity(ActivityDTO activityDTO);
    void updateActivity(ActivityDTO activityDTO);
    void deleteActivity(String name);
}
