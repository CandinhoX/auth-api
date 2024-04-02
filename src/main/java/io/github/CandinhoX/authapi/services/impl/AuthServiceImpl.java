package io.github.CandinhoX.authapi.services.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import io.github.CandinhoX.authapi.dtos.AuthDto;
import io.github.CandinhoX.authapi.models.User;
import io.github.CandinhoX.authapi.repositories.UserRepository;
import io.github.CandinhoX.authapi.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class AuthServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByLogin(login);
    }

    @Override
    public String gtToken(AuthDto authDto) {

        User user = userRepository.findByLogin(authDto.login());

        return generateTokenJwt(user);
    }

    public String generateTokenJwt(User user){
        try{

            Algorithm algorithm = Algorithm.HMAC256("my-secret");

            return JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(user.getLogin())
                    .withExpiresAt(generateExpireDate())
                    .sign(algorithm);
        }catch(JWTCreationException e){
            throw new RuntimeException("Generate token error! " + e.getMessage());
        }
    }

    private Instant generateExpireDate() {
        return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"));
    }
}
