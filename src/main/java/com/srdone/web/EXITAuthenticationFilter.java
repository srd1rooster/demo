package com.srdone.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lszakacs on 0009, June 09, 2016.
 */

public class EXITAuthenticationFilter extends OncePerRequestFilter{

    @Autowired
    @Qualifier("srd1AM")
    protected AuthenticationManager am;

    @Override
    protected void doFilterInternal(HttpServletRequest request
                                    , HttpServletResponse response
                                    , FilterChain filterChain)
            throws ServletException, IOException {

//        WebApplicationContext wac = WebApplicationContextUtils.findWebApplicationContext(request.getServletContext());
//        AuthenticationManager am = (AuthenticationManager) wac.getBean("srd1AM");

        String uid = request.getParameter("uid");
        String pwd = request.getParameter("pwd");
//TODO this comes from http://shout.setfive.com/2015/11/02/spring-boot-authentication-with-custom-http-header/
//        String xAuth = request.getHeader("X-Authorization");
//
//        // validate the value in xAuth
//        if(isValid(xAuth) == false){
//            throw new SecurityException();
//        }
//
//        // The token is 'valid' so magically get a user id from it
//        Long id = getUserIdFromToken(xAuth);

        // Create our Authentication and let Spring know about it
//        List<GrantedAuthority> grantedAuths = new ArrayList<>();
//        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
        Authentication aToken = new UsernamePasswordAuthenticationToken( uid, pwd);
        am.authenticate(aToken);
        SecurityContextHolder.getContext().setAuthentication(aToken);

        filterChain.doFilter(request, response);
    }

}
