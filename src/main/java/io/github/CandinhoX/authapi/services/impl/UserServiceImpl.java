package io.github.CandinhoX.authapi.services.impl;

import io.github.CandinhoX.authapi.dtos.UserDto;
import io.github.CandinhoX.authapi.models.User;
import io.github.CandinhoX.authapi.repositories.UserRepository;
import io.github.CandinhoX.authapi.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Transactional
    @Override
    public UserDto save(UserDto userDto) {
        User existedUser = userRepository.findByLogin(userDto.login());

        if(existedUser != null){
            throw new RuntimeException("User already exist");
        }
        var passwordHash = passwordEncoder.encode(userDto.password());
        var entity =  new User(userDto.name(), userDto.login(), passwordHash);
        var newUser = userRepository.save(entity);
        return new UserDto(newUser.getName(), newUser.getLogin(), newUser.getPassword());

    }
}
