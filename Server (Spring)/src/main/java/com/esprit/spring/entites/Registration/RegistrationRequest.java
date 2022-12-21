package com.esprit.spring.entites.Registration;

import java.util.Date;

import com.esprit.spring.entites.Profession;

import lombok.AllArgsConstructor;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Date dateNaissance;
    private final String password;
    private final Profession profession;
    
}

