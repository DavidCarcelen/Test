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

    public static UserDTO toDTO(User user){
        UserDTO userDTO = new UserDTO(user.getName(),user.getLastName());
        return userDTO;
    }

    public static User updateUser (User user, UserDTO userDTO){
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        user.setAge(userDTO.getAge());
        return user;
    }
}
