package com.mendix.restapi.repository;

import com.mendix.restapi.model.Ingredient;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class IngredientRepositoryImpl implements IngredientRepositoryCustom {
    @PersistenceContext
    private EntityManager em;
    @Override
    @Transactional
    public void refresh(Ingredient ingredient) {
     //   this.em.flush();
        em.refresh(em.merge(ingredient));

    }


}
