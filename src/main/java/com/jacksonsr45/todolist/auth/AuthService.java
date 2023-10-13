package com.jacksonsr45.todolist.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.jacksonsr45.todolist.user.UserModel;


@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public AuthResponseDTO login(AuthRequestDTO data) throws AuthenticationException {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        
        var auth = authenticationManager.authenticate(usernamePassword);
        
        var token = tokenService.generateToken((UserModel) auth.getPrincipal());
        
        return new AuthResponseDTO(token);
    }
}
