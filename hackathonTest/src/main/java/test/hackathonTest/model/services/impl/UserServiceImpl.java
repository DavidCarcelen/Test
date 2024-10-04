package test.hackathonTest.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.hackathonTest.exceptions.IdNotFoundException;
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
    public void updateUser(long id, UserDTO userDTO) {
        User userToUpdate = userRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("User not found with ID: " + id));
        User updatedUser = UserMapper.updateUser(userToUpdate, userDTO);
        userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("User not found with ID: " + id));
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getUser(long id) {
        User userToReturn =  userRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("User not found with ID: " + id));
        return UserMapper.toDTO(userToReturn);
    }

    public void availabilityChecker(String email) {
        userRepository.findByEmail(email)
                .ifPresent(user -> {
                    throw new RegisteredEmailException("Email already registered:" + email);
                });
    }


}
