package com.mendix.restapi.service;

import com.mendix.restapi.model.Ingredient;
import com.mendix.restapi.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneralService {
    private IngredientRepository ingredientRepository;
    @Autowired
    public void setIngredientRepository(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    public Long getLastId(){
        Ingredient lastIng=ingredientRepository.findTopByOrderByIdDesc();
        return lastIng.getId();
    }

    public Boolean dataExists(){
        System.out.print(ingredientRepository.count()+"Count");
        return ingredientRepository.count()>0;
    }

}
