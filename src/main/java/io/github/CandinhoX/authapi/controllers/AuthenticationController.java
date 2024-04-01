package io.github.CandinhoX.authapi.controllers;

import io.github.CandinhoX.authapi.dtos.AuthDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String auth(@RequestBody AuthDto authDto){

        var userAuthenticationToken = new UsernamePasswordAuthenticationToken(authDto.login(), authDto.password());
        authenticationManager.authenticate(userAuthenticationToken);
        return "token ...";
    }

}
