package com.mendix.restapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mendix.restapi.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe ,String>{
    Recipe findTopByOrderByIdDesc();

}
