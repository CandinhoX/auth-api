package io.github.CandinhoX.authapi.controllers;

import io.github.CandinhoX.authapi.dtos.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    private UserDto save(@RequestBody UserDto userDto){
        return userDto;
    }

}
