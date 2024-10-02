package test.hackathonTest.model.mappers;

import test.hackathonTest.model.domain.User;
import test.hackathonTest.model.dto.UserDTO;

import java.util.Date;

public class UserMapper {
    public static User toEntity(UserDTO userDTO) {
        User user = User.builder()
                .name(userDTO.getName())
                .lastName(userDTO.getLastName())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .age(userDTO.getAge())
                .build();

        return user;
    }
}
