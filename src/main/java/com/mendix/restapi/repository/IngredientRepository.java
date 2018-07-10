package com.mendix.restapi.repository;

import com.mendix.restapi.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,String> ,IngredientRepositoryCustom{
    Ingredient findTopByOrderByIdDesc();
}
