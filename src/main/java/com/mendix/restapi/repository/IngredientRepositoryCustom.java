package com.mendix.restapi.repository;

import com.mendix.restapi.model.Ingredient;

public interface IngredientRepositoryCustom {
    void refresh(Ingredient ingredient);
}
