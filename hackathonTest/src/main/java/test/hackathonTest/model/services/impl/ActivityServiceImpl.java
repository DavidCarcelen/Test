package test.hackathonTest.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.hackathonTest.exceptions.ActivityFullException;
import test.hackathonTest.exceptions.IdNotFoundException;
import test.hackathonTest.model.domain.Activity;
import test.hackathonTest.model.dto.ActivityDTO;
import test.hackathonTest.model.mappers.ActivityMapper;
import test.hackathonTest.model.repository.ActivityRepository;
import test.hackathonTest.model.services.ActivityService;
import test.hackathonTest.model.services.UserService;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public void newActivity(ActivityDTO activityDTO) {
        Activity newActivity = ActivityMapper.toEntity(activityDTO);
        activityRepository.save(newActivity);
    }

    @Override
    public void updateActivity(long id, ActivityDTO activityDTO) {
        Activity activityToUpdate = activityRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Activity not found with ID: " + id));
        Activity updatedActivity = ActivityMapper.updateActivity(activityToUpdate, activityDTO);
        activityRepository.save(updatedActivity);

    }

    @Override
    public void deleteActivity(long id) {
        activityRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Activity not found with ID: " + id));
        activityRepository.deleteById(id);

    }

    @Override
    public String addUser(long idActivity) {
        Activity activity = activityRepository.findById(idActivity)
                .orElseThrow(() -> new IdNotFoundException("Activity not found with ID: " + idActivity));
        if (activity.getMaxUsers() > activity.getInUsers()) {
            activity.setInUsers(activity.getInUsers() + 1);
        } else throw new ActivityFullException("There are no places left for this activity");
        return activity.getName();
    }

}
