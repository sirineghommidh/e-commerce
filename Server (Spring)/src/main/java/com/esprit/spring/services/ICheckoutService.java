package com.esprit.spring.services;

import com.esprit.spring.entites.achat.Achat;
import com.esprit.spring.entites.achat.ReponseAchat;

public interface ICheckoutService {
    ReponseAchat PasserCommande(Achat achat);
}
