package com.nujabness.katawemanity.services.authentification;

import com.nujabness.katawemanity.beans.request.LoginRequest;
import com.nujabness.katawemanity.services.authentification.provider.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;


@Component
public class AuthenticationProvider {

    @Autowired
    private CustomAuthenticationProvider authenticationManager;


    public AuthenticationProvider(CustomAuthenticationProvider authenticationManager) {
        this.authenticationManager=authenticationManager;
    }

    public CustomUsernamePasswordAuthenticationToken authenticate(LoginRequest data){
        try {
            return (CustomUsernamePasswordAuthenticationToken) authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword()));

        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
}
