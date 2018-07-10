package com.mendix.restapi.controller;


import java.util.Optional;
import java.util.List;

import com.mendix.restapi.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.mendix.restapi.model.Recipe;


import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/recipes/")
//@Api(value = "ProductsControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class RecipeController {
	   private RecipeService recipeService;

	   // private Logger LOG = LoggerFactory.getLogger(ProductsController.class);

		@Autowired
		public void setRecipesService(RecipeService recipeService) {
			this.recipeService = recipeService;
		}

	    @RequestMapping(path = "{id}", method = RequestMethod.GET)
	    // @ApiOperation("Gets the product with specific id")
	   // @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Product.class)})
	    public Optional<Recipe> getRecipe(@PathVariable(name = "id") String id) {
			return recipeService.getRecipe(id);
	    }

		@RequestMapping( method = RequestMethod.GET)
		// @ApiOperation("Gets the product with speRecipecific id")
		// @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Product.class)})
		public List<Recipe> getRecipeAll() {
			return recipeService.getRecipeAll();
	}

		@RequestMapping(path = "category/{category}",method = RequestMethod.GET)
		// @ApiOperation("Gets the product with specific id")
		// @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Product.class)})
		public List<Recipe> getRecipeFilteredByCategory(@PathVariable(name = "category") String category) {
			return recipeService.getRecipeFilteredByCategory(category);
		}
		@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public Recipe saveRecipe(@Valid @RequestBody Recipe recipeToSave) {
			return recipeService.saveRecipe(recipeToSave);
		}

	    @RequestMapping(path="save",method = RequestMethod.GET)
	    public Recipe saveTestRecipe() {
		return recipeService.saveTestRecipe();
	}



}
