package test.hackathonTest.model.services;

import test.hackathonTest.model.dto.UserDTO;

public interface UserService {
    void newUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    void deleteUser(String email);
    UserDTO getUser (String email);
}
