package test.hackathonTest.model.mappers;

import test.hackathonTest.model.domain.Activity;
import test.hackathonTest.model.domain.User;
import test.hackathonTest.model.dto.ActivityDTO;
import test.hackathonTest.model.dto.UserDTO;

public class ActivityMapper {
    public static Activity toEntity(ActivityDTO activityDTO) {
        Activity activity = Activity.builder()
                .name(activityDTO.getName())
                .about(activityDTO.getAbout())
                .maxUsers(activityDTO.getMaxUsers())
                .build();

        return activity;
    }
}
