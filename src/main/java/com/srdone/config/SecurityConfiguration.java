package com.srdone.config;

/**
 * Created by lszakacs on 0008, June 08, 2016.
 */

import com.srdone.web.EXITAuthenticationFilter;
import com.srdone.web.EXITAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Bean(name = "srd1sec")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    private EXITAuthenticationProvider ap;

    @Bean
    public SessionRegistry sessionRegistry() {
        SessionRegistry sessionRegistry = new SessionRegistryImpl();
        return sessionRegistry;
    }

    @Override
    protected void configure(HttpSecurity https) throws Exception {
        https.csrf().disable()
            .authorizeRequests()
////            .antMatchers("/static/**")
////            .permitAll()
//            .anyRequest()
//            .authenticated()
        .and()
//            .addFilterBefore(new EXITAuthenticationFilter(), BasicAuthenticationFilter.class)
            .formLogin()
            .loginPage("/login_orig.html")//.passwordParameter("pwd").usernameParameter("uid")
            .permitAll()
        .and()
            .sessionManagement()
            .maximumSessions(1)
            .expiredUrl("/expired")
            .maxSessionsPreventsLogin(true)
            .sessionRegistry(sessionRegistry());

    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(ap);
    }

}
