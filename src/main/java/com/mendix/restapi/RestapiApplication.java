package com.mendix.restapi;

import com.mendix.restapi.model.*;

import com.mendix.restapi.repository.*;
import com.mendix.restapi.service.CustomGenerator;
import com.mendix.restapi.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RestapiApplication implements CommandLineRunner {
	
	private RecipeRepository RecipeRepository;
	private RecipeHeadRepository RecipeHeadRepository;
	private IngredientRepository IngredientRepository;
	private IngredientAmountRepository IngredientAmountRepository;
	private CategoryRepository CategoryRepository;



	RecipeService recipeService;
	@Autowired
	public void RecipeService(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

	recipeService.saveTestRecipe();

	}
   /* public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }*/
}
