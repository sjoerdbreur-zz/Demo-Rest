package com.mendix.restapi;

import com.mendix.restapi.model.*;

import com.mendix.restapi.repository.*;
import com.mendix.restapi.service.CustomGenerator;
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

	/*@Autowired
	public void RecipeRepository(RecipeRepository RecipeRepository) {
		this.RecipeRepository = RecipeRepository;
	}

	@Autowired
	public void RecipeHeadRepository(RecipeHeadRepository RecipeHeadRepository) { this.RecipeHeadRepository = RecipeHeadRepository; }

	@Autowired
	public void CategoryRepository(CategoryRepository CategoryRepository) {
		this.CategoryRepository = CategoryRepository;
	}

	@Autowired
	public void IngredientRepository(IngredientRepository IngredientRepository) {
		this.IngredientRepository = IngredientRepository;
	}

	@Autowired
	public void IngredientAmountRepository(IngredientAmountRepository IngredientAmountRepository) {
		this.IngredientAmountRepository = IngredientAmountRepository;
	}

	CustomGenerator customGenerator;
	@Autowired
	public void CustomGenerator(CustomGenerator customGenerator) {
		this.customGenerator = customGenerator;
	}*/

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

	/*	Recipe testRecipe = new Recipe();
		testRecipe.setId("paneerMakhni");
		testRecipe.setDescription("Simple Recipe");
		testRecipe.setDescription("This is a tester Recipe");

		RecipeHead recipeHead=new RecipeHead(testRecipe.getId(),"Paneer makhni",6,testRecipe);
		Category category1=new Category("Main Dish");
		Category category2=new Category("Chilli");
		CategoryRepository.save(category1);
		CategoryRepository.save(category2);

		ArrayList<Category> categories=new ArrayList<>();
		categories.add(category1);
		categories.add(category2);
		recipeHead.setCategories(categories);

		RecipeHeadRepository.save(recipeHead);
		testRecipe.setRecipeHead(recipeHead);
		Ingredient ing=new Ingredient();
		//long a=customGenerator.generateIngredientId();
		//ing.setId(1);
		ing.setItems("paneer");
		ing.setIngId(testRecipe.getId());
		//EntityManager=
		//Object id = entityManagerFactory.getPersistenceUnitUtil().getIdentifier(entity);
		IngredientRepository.save(ing);
		IngredientAmount ingAmount=new IngredientAmount(ing.getId(),1,"gram");
		IngredientAmountRepository.save(ingAmount);
		ing.setIngAmount(ingAmount);

		Ingredient ing2=new Ingredient();
		//ing2.setId(customGenerator.generateIngredientId());
		ing2.setItems("Butter");
		ing2.setIngId(testRecipe.getId());
		IngredientRepository.save(ing2);
		IngredientAmount ingAmount2=new IngredientAmount(ing2.getId(),1,"lb");
		IngredientAmountRepository.save(ingAmount2);
		ing.setIngAmount(ingAmount2);

		Ingredient ing3=new Ingredient();
		//ing3.setId(customGenerator.generateIngredientId());
		ing3.setItems("Onion; large, chopped");
		ing3.setIngId(testRecipe.getId());
		IngredientRepository.save(ing3);
		IngredientAmount ingAmount3=new IngredientAmount(ing3.getId(),1,"lb");
		IngredientAmountRepository.save(ingAmount3);
		ing3.setIngAmount(ingAmount3);


		ArrayList<Ingredient> ingredients=new ArrayList<>();
		ingredients.add(ing);
		ingredients.add(ing2);
		ingredients.add(ing3);
		testRecipe.setIngredients(ingredients);

		RecipeRepository.save(testRecipe);*/

	}
   /* public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }*/
}
