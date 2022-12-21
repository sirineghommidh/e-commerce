package com.esprit.spring.security.config;

import com.esprit.spring.entites.LoginRequest;
import com.esprit.spring.security.PasswordEncoder;
import com.esprit.spring.services.UserServiceImpl;
import com.esprit.spring.utils.filter.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.esprit.spring.services.UserServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collection;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserServiceImpl appUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    JwtRequestFilter jwtRequestFilter;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin", "/admin/**").hasRole("ADMIN")
                .antMatchers("/client","/client/**").hasAnyRole("CLIENT", "ADMIN")
                .antMatchers("/authenticate","/**").permitAll()
                .anyRequest().authenticated()
                //.antMatchers("/**").permitAll()
                //.and().formLogin();
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    
    
    //  login 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {    
        auth.authenticationProvider(daoAuthenticationProvider());

    }
  

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
    	
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(appUserService);
        
        return provider;
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
