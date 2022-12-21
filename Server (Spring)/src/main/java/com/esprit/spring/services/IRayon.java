package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Rayon;

public interface IRayon {
	List<Rayon> retrieveAllRayons();

	Rayon addRayon(Rayon p);

	void deleteRayon(Long id);

	Rayon updateRayon(Rayon u);

	Rayon retrieveRayon(Long id);
}
