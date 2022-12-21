package com.esprit.spring.controller;

import com.esprit.spring.entites.CategorieReclamation;
import com.esprit.spring.repository.CategorieReclamationRepository;
import com.esprit.spring.services.ICategorieReclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/categorieReclamation")
public class CategorieReclamationController {
    @Autowired
    private ICategorieReclamation categoryService;

    @Autowired
    private CategorieReclamationRepository categoryRepository;


    @GetMapping("/retrieve-all-categories")
    @ResponseBody
    public List<CategorieReclamation> GetAllCategories()
    {
        List<CategorieReclamation> categories = categoryService.retrieveAllCategories();
        return categories;
    }

    @PostMapping("/client/add-category")
    @ResponseBody
    public CategorieReclamation addCategory(@RequestBody CategorieReclamation c)
    {
        categoryService.addCategory(c);
        return c;
    }

    @DeleteMapping("/admin/delete-category/{cat-id}")
    @ResponseBody
    public void deleteCategory(@PathVariable("cat-id") Long id)
    {
        categoryService.DeleteCategory(id);
    }

    @PutMapping("/admin/update-category")
    @ResponseBody
    public CategorieReclamation updateCategory(@RequestBody CategorieReclamation c)
    {
        return categoryService.updateCategory(c);
    }

    @GetMapping("/admin/get-one-category/{cat-id}")
    @ResponseBody
    public CategorieReclamation getOneCategory(@PathVariable("cat-id") Long id)
    {
        CategorieReclamation category = categoryService.retrieveOneCategory(id);
        return category;
    }

    @GetMapping("/admin/get-inactive")
    @ResponseBody
    public List<CategorieReclamation> GetInactive()
    {
        List<CategorieReclamation> categories = categoryService.retrieveInactiveCategories();
        return categories;
    }

    @GetMapping("/get-active")
    @ResponseBody
    public List<CategorieReclamation> GetActive()
    {
        List<CategorieReclamation> categories = categoryService.retrieveActiveCategories();
        return categories;
    }

    // http://localhost:8081/idmax
    @GetMapping("/idmax")
    @ResponseBody
    public Long retrieveLastCat() {
        return categoryRepository.getLastElementId();
    }

}
