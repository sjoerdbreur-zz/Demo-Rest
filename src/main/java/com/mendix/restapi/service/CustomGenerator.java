package com.mendix.restapi.service;

import com.mendix.restapi.service.RecipeService;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;

import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.IdentityGenerator;
import org.hibernate.id.factory.internal.DefaultIdentifierGeneratorFactory;

import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.spi.ServiceRegistry;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Properties;
@Service
public class CustomGenerator {

     private RecipeService recipeService;

    @Autowired
    public void setRecipesService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    private GeneralService generalService;

    @Autowired
    public void setGeneralService(GeneralService generalService) {
        this.generalService = generalService;
    }

    public String generateRecipeId()
            throws HibernateException {
        String prefix = "RECIPE";
        if(recipeService.dataExists()){
            String id=recipeService.getLastId();
            String generatedId=prefix+(Integer.parseInt(id.substring(6))+1);
            return generatedId;
        }else return prefix+1;

    }
    public long generateIngredientId()
            throws HibernateException {
        if(generalService.dataExists()){
           long id=generalService.getLastId();
            return id+1;
        }else return (long)1;

    }

}
