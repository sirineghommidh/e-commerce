package com.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Commentaire;
import com.esprit.spring.repository.CommentaireRepository;


@Service
public class CommentaireServiceImpl implements ICommentaire {
	@Autowired
	private CommentaireRepository commentaireRepository;


	
	public List<Commentaire> retrieveAllCommentaires() {
		// TODO Auto-generated method stub
		List<Commentaire> commentaires = (List<Commentaire>) commentaireRepository.findAll();
		
		return commentaires;
	}

	
	public Commentaire addCommentaire(Commentaire c) {
		// TODO Auto-generated method stub
		commentaireRepository.save(c);
		return c;
	}

	
	public void deleteCommentaire(Long id) {
		// TODO Auto-generated method stub
		commentaireRepository.deleteById(id);

	}


	public Commentaire updateCommentaire(Commentaire u) {
		// TODO Auto-generated method stub
		return commentaireRepository.save(u);
	}


	public Commentaire retrieveCommentaire(Long id) {
		// TODO Auto-generated method stub
		Commentaire commentaire = commentaireRepository.findById(id).orElse(null);
		return commentaire;
	}
	

}
