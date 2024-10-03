package test.hackathonTest.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActivityDTO {
    private long id;
    private String name;
    private String about;
    private int maxUsers;
    private boolean full;
}
