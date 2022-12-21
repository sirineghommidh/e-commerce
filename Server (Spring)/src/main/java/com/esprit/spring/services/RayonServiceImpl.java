package com.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Rayon;
import com.esprit.spring.repository.RayonRepository;
@Service
public class RayonServiceImpl implements IRayon {
	@Autowired
	private RayonRepository rayonRepository;


	@Override
	public List<Rayon> retrieveAllRayons() {
		// TODO Auto-generated method stub
		List<Rayon> Rayons = (List<Rayon>) rayonRepository.findAll();
		return Rayons;
	}

	@Override
	public Rayon addRayon(Rayon p) {
		// TODO Auto-generated method stub
		rayonRepository.save(p);
		return p;
	}

	@Override
	public void deleteRayon(Long id) {
		// TODO Auto-generated method stub
		rayonRepository.deleteById(id);

	}

	@Override
	public Rayon updateRayon(Rayon u) {
		// TODO Auto-generated method stub
		return rayonRepository.save(u);
	}

	@Override
	public Rayon retrieveRayon(Long id) {
		// TODO Auto-generated method stub
		Rayon Rayon = rayonRepository.findById(id).orElse(null);
		return Rayon;
	}
}
