package com.esprit.spring.services;


import com.esprit.spring.entites.CategorieReclamation;
import com.esprit.spring.repository.CategorieReclamationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategorieReclamationServiceImp implements ICategorieReclamation{

    @Autowired
    private CategorieReclamationRepository categoryRepository;

    @Override
    public List<CategorieReclamation> retrieveAllCategories()
    {
        List<CategorieReclamation> categories = (List<CategorieReclamation>) categoryRepository.findAll();
        return categories;
    }

    @Override
    public CategorieReclamation addCategory(CategorieReclamation c) {
        categoryRepository.save(c);
        return c;
    }

    @Override
    public void DeleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public CategorieReclamation updateCategory(CategorieReclamation c) {
        return categoryRepository.save(c);

    }

    @Override
    public CategorieReclamation retrieveOneCategory(Long id) {
        CategorieReclamation category = categoryRepository.findById(id).orElse(null);
        return category;
    }

    @Override
    public List<CategorieReclamation> retrieveInactiveCategories()
    {
        List<CategorieReclamation> categories = categoryRepository.findInactiveCategories();
        return categories;
    }

    @Override
    public List<CategorieReclamation> retrieveActiveCategories()
    {
        List<CategorieReclamation> categories = categoryRepository.findActiveCategories();
        return categories;
    }




}
