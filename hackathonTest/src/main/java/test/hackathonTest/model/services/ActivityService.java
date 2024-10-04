package test.hackathonTest.model.services;

import test.hackathonTest.model.domain.Activity;
import test.hackathonTest.model.dto.ActivityDTO;
import test.hackathonTest.model.dto.UserDTO;

import java.util.List;

public interface ActivityService {
    void newActivity(ActivityDTO activityDTO);
    void updateActivity(long id, ActivityDTO activityDTO);
    void deleteActivity(long id);
    String addUser(long id);

    List<Activity> getAllActivities();

    void saveAllActivities(List<Activity> activities);
}
