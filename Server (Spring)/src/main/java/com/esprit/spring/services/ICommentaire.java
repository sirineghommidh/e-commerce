package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Commentaire;

public interface ICommentaire {
	List<Commentaire> retrieveAllCommentaires();

	Commentaire addCommentaire(Commentaire c);

	void deleteCommentaire(Long id);

	Commentaire updateCommentaire(Commentaire c);

	Commentaire retrieveCommentaire(Long id);

}
