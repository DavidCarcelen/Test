package test.hackathonTest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {
    private long id;
    private String name;
    private String lastName;
    private String password;
    private String email;
    private int age;
    private List<String> activityIdList;

    public UserDTO(String email){
        this.email = email;
    }
}
