package test.hackathonTest.model.mappers;

import test.hackathonTest.model.domain.Activity;
import test.hackathonTest.model.dto.ActivityDTO;

public class ActivityMapper {
    public static Activity toEntity(ActivityDTO activityDTO) {
        Activity activity = Activity.builder()
                .name(activityDTO.getName())
                .about(activityDTO.getAbout())
                .maxUsers(activityDTO.getMaxUsers())
                .build();

        return activity;
    }

    public static Activity updateActivity (Activity activityToUpdate, ActivityDTO activityDTO){
        activityToUpdate.setAbout(activityDTO.getAbout());
        activityToUpdate.setMaxUsers(activityDTO.getMaxUsers());

        return activityToUpdate;
    }
}
