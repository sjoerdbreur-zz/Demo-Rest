package com.mendix.restapi.service;
import com.mendix.restapi.model.*;
import com.mendix.restapi.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeService {
    private Logger LOG = LoggerFactory.getLogger(RecipeService.class);

    private com.mendix.restapi.repository.RecipeHeadRepository RecipeHeadRepository;
    private com.mendix.restapi.repository.IngredientRepository IngredientRepository;
    private com.mendix.restapi.repository.IngredientAmountRepository IngredientAmountRepository;
    private com.mendix.restapi.repository.CategoryRepository CategoryRepository;

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
    }


    private RecipeRepository recipeRepository;
    private CategoryService categoryService;

    @Autowired
    public void setRecipeRepository(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    public Optional<Recipe> getRecipe(String id) {
        LOG.info("Getting the recipe with given id:" + id);
        Optional<Recipe> recipe = recipeRepository.findById(id);
        return recipe;
    }
    public  List<Recipe> getRecipeAll() {
        List<Recipe> all = recipeRepository.findAll();
        return all;
    }
    public  List<Recipe> getRecipeFilteredByCategory(String Category) {
        //  LOG.info("Getting the product with given id:" + id);
        Optional<com.mendix.restapi.model.Category> category=categoryService.getCategory(Category);
        List<Recipe> all = recipeRepository.findAll();
        List<Recipe> filteredRecipe=all.stream().filter(recipe -> recipe.getRecipeHead().getCategories().contains(category.get())).collect(Collectors.toList());
       return filteredRecipe;
    }
    public Recipe saveRecipe(Recipe recipeToSave){
        try{
            Recipe recipe = new Recipe();
            recipe.setId(customGenerator.generateRecipeId());
            recipe.setDescription(recipeToSave.getDescription());

            RecipeHead recipeHead=recipeToSave.getRecipeHead();
            recipeHead.setId(recipe.getId());

            List<Category> categories=recipeHead.getCategories();
            categories.forEach(category ->CategoryRepository.save(category));
            RecipeHeadRepository.save(recipeHead);
            recipe.setRecipeHead(recipeHead);

            List<Ingredient> ingredients=recipeToSave.getIngredients();
            ingredients.forEach(ingredient -> {
                ingredient.setId(customGenerator.generateIngredientId());
                ingredient.setIngId(recipeToSave.getId());
                ingredient.getIngAmount().setId(ingredient.getId());
                IngredientAmountRepository.save( ingredient.getIngAmount());
                IngredientRepository.saveAndFlush(ingredient);
            });
            recipe.setIngredients(ingredients);
            recipeRepository.save(recipe);
            return recipe;
        }catch (Exception e){
            LOG.error("An error occurred during  saving:" + e.getMessage());
        }
        return recipeToSave;
    }
    public Recipe saveTestRecipe() {//Recipe recipe
        Recipe recipeToSave;
        try {

            Recipe testRecipe = new Recipe();

            testRecipe.setId(customGenerator.generateRecipeId());
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
           // long a=customGenerator.generateIngredientId();
            ing.setId(customGenerator.generateIngredientId());
            ing.setItems("paneer");
            ing.setIngId(testRecipe.getId());
            //EntityManager=
            //Object id = entityManagerFactory.getPersistenceUnitUtil().getIdentifier(entity);
           // IngredientRepository.save(ing);
            IngredientAmount ingAmount=new IngredientAmount(ing.getId(),1,"gram");
            IngredientAmountRepository.save(ingAmount);
            ing.setIngAmount(ingAmount);
            IngredientRepository.save(ing);


            Ingredient ing2=new Ingredient();
            ing2.setId(customGenerator.generateIngredientId());
            ing2.setItems("Butter");
            ing2.setIngId(testRecipe.getId());
            //IngredientRepository.save(ing2);
            IngredientAmount ingAmount2=new IngredientAmount(ing2.getId(),1,"lb");
            IngredientAmountRepository.save(ingAmount2);
            ing2.setIngAmount(ingAmount2);
            IngredientRepository.save(ing2);


            Ingredient ing3=new Ingredient();
            ing3.setId(customGenerator.generateIngredientId());
            ing3.setItems("Onion; large, chopped");
            ing3.setIngId(testRecipe.getId());
            //IngredientRepository.save(ing3);
            IngredientAmount ingAmount3=new IngredientAmount(ing3.getId(),1,"lb");
            IngredientAmountRepository.save(ingAmount3);
            IngredientRepository.save(ing3);
            ing3.setIngAmount(ingAmount3);


            ArrayList<Ingredient> ingredients=new ArrayList<>();
            ingredients.add(ing);
            ingredients.add(ing2);
            ingredients.add(ing3);
            testRecipe.setIngredients(ingredients);

            recipeRepository.save(testRecipe);



        } catch (Exception e) {
           // LOG.error("An error occurred during product saving:" + e.getMessage());
        }
        return new Recipe();
    }

    public String getLastId(){
        Recipe lastRecipe=recipeRepository.findTopByOrderByIdDesc();
        return lastRecipe.getId();
    }

    public Boolean dataExists(){
        return recipeRepository.count()>0;
    }
    //add method
}
