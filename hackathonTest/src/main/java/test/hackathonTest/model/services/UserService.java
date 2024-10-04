package test.hackathonTest.model.services;

import test.hackathonTest.model.dto.UserDTO;

public interface UserService {
    void newUser(UserDTO userDTO);
    void updateUser(long id, UserDTO userDTO);
    void deleteUser(long id);
    UserDTO getUser (long id);
    void signUp(long idUser, long idActivity);
}
