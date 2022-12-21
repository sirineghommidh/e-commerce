package com.esprit.spring.services;

import com.esprit.spring.entites.CategorieReclamation;

import java.util.List;

public interface ICategorieReclamation {

    List<CategorieReclamation> retrieveAllCategories();

    CategorieReclamation addCategory(CategorieReclamation c);

    void DeleteCategory(Long id);

    CategorieReclamation updateCategory(CategorieReclamation c);

    CategorieReclamation retrieveOneCategory(Long id);

    List<CategorieReclamation> retrieveInactiveCategories();

    List<CategorieReclamation> retrieveActiveCategories();


}
