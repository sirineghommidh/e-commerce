package com.esprit.spring.services;

import com.esprit.spring.entites.Adresse;

import java.util.List;

public interface IAdresse {
    List<Adresse> retrieveAllAdresses();

    Adresse addAdresse(Adresse c);

    void deleteAdresse(Long id);

    Adresse updateAdresse(Adresse u);

    Adresse retrieveAdresse(Long id);
}
