package test.hackathonTest.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private String name;
    private String lastName;
    private String password;
    private String email;
    private int age;
}
