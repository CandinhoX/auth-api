package io.github.CandinhoX.authapi.services;

import io.github.CandinhoX.authapi.dtos.AuthDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationService extends UserDetailsService {

    public String gtToken(AuthDto authDto);

}
