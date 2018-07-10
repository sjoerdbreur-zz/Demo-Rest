package com.mendix.restapi.repository;

import com.mendix.restapi.model.IngredientAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientAmountRepository extends JpaRepository<IngredientAmount,String> {
}
