package test.hackathonTest.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public void newUser (UserDTO userDTO){
        checker(userDTO.getEmail());
        User entityUser = UserMapper.toEntity(userDTO);
        userRepository.save(entityUser);
    }

    public void checker(String email){
        userRepository.findByEmail(email)
                .ifPresent(user -> {
                    throw new RegisteredEmailException("email already registered:" + email);
                });
        //check if email available, eslse throw newexception
    }
}
