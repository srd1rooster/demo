package com.srdone.web;

import com.srdone.domain.LoginEntity;
import com.srdone.service.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lszakacs on 0009, June 09, 2016.
 */
@Component
public class EXITAuthenticationProvider implements AuthenticationProvider {
    private final LoginRepository lp;

    @Autowired
    public EXITAuthenticationProvider(LoginRepository lp) {
        this.lp = lp;
    }

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException{
//        UsernamePasswordAuthenticationToken upat = (UsernamePasswordAuthenticationToken) auth;
        String uid = auth.getName();
        String pwd = auth.getCredentials().toString();

        LoginEntity user = lp.findByUserId(uid);

        if(user == null){
            throw new UsernameNotFoundException("Could not find user with ID: " + uid);
        }

        if (!pwd.equals(user.getPassword())) {
            throw new BadCredentialsException("Invalid username/password");
        }

        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return  UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
