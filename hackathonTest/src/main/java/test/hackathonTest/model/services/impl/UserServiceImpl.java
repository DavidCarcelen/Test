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

import java.util.Optional;

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

    public void updateUser(UserDTO userDTO) {
        User userToUpdate = userRepository.findByEmail(userDTO.getEmail())
                .orElseThrow(() -> new EmailNotFoundException("Email not found: " + userDTO.getEmail()));
        User updatedUser = UserMapper.updateUser(userToUpdate, userDTO);
        userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(String email) {
        User userToDelete = userRepository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("Email not found: " + email));
        userRepository.delete(userToDelete);
    }

    @Override
    public UserDTO getUser(String email) {
        User userToReturn = userRepository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("Email not found: " + email));
        UserDTO userDTO = UserMapper.toDTO(userToReturn);
        return userDTO;
    }

    public void availabilityChecker(String email) {
        userRepository.findByEmail(email)
                .ifPresent(user -> {
                    throw new RegisteredEmailException("Email already registered:" + email);
                });
    }


}
