package com.mendix.restapi.service;

import com.mendix.restapi.model.Category;
import com.mendix.restapi.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private Logger LOG = LoggerFactory.getLogger(RecipeService.class);
    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Category> getCategoryAll() {
        List<Category> allCat = categoryRepository.findAll();
        LOG.info("no of categories in db"+allCat.size());
        return allCat;
    }


    public Optional<Category> getCategory(String id) {
        LOG.info("searching category "+id);
        Optional<Category> cp = categoryRepository.findById(id);
        return cp;
    }
}
