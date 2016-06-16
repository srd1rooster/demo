package com.srdone.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lszakacs on 0008, June 08, 2016.
 */
@Controller
public class LoginController {

    @Autowired
    @Qualifier("srd1sec")
    protected AuthenticationManager am;

    @RequestMapping(value = "/api/signin", method = RequestMethod.POST)
    public String login(@RequestParam("UID") String uid
            , @RequestParam("PWD") String pwd
            , Model m){
        try{
            Authentication aToken = new UsernamePasswordAuthenticationToken( uid, pwd)
                    , adUser = am.authenticate(aToken);

            SecurityContextHolder.getContext().setAuthentication(adUser);

        }catch(AuthenticationException e){
            m.addAttribute("error", e.getMessage());
            return "login";
        }

        return "index";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }
}
