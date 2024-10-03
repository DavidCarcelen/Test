package test.hackathonTest.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import test.hackathonTest.model.domain.Activity;
import test.hackathonTest.model.dto.ActivityDTO;
import test.hackathonTest.model.mappers.ActivityMapper;
import test.hackathonTest.model.repository.ActivityRepository;
import test.hackathonTest.model.services.ActivityService;

public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;
    @Override
    public void newActivity(ActivityDTO activityDTO) {
        Activity newActivity = ActivityMapper.toEntity(activityDTO);
        activityRepository.save(newActivity);
    }

    @Override
    public void updateActivity(ActivityDTO activityDTO) {

    }

    @Override
    public void deleteActivity(String name) {

    }
}
