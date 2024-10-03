package test.hackathonTest.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.hackathonTest.exceptions.EmailNotFoundException;
import test.hackathonTest.exceptions.RegisteredEmailException;
import test.hackathonTest.model.domain.User;
import test.hackathonTest.model.dto.UserDTO;
import test.hackathonTest.model.mappers.UserMapper;
import test.hackathonTest.model.repository.UserRepository;
import test.hackathonTest.model.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void newUser(UserDTO userDTO) {
        availabilityChecker(userDTO.getEmail());
        User entityUser = UserMapper.toEntity(userDTO);
        userRepository.save(entityUser);
    }
    @Override
    public void updateUser(UserDTO userDTO) {
        User userToUpdate = userFinder(userDTO.getEmail());
        User updatedUser = UserMapper.updateUser(userToUpdate, userDTO);
        userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(String email) {
        User userToDelete = userFinder(email);
        userRepository.delete(userToDelete);
    }

    @Override
    public UserDTO getUser(String email) {
        User userToReturn = userFinder(email);
        return UserMapper.toDTO(userToReturn);
    }

    public void availabilityChecker(String email) {
        userRepository.findByEmail(email)
                .ifPresent(user -> {
                    throw new RegisteredEmailException("Email already registered:" + email);
                });
    }
    public User userFinder (String email){
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("Email not found: " + email));
        return user;
    }


}
