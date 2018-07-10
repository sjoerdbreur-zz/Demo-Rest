package com.mendix.restapi.controller;

import com.mendix.restapi.model.Category;
import com.mendix.restapi.model.Recipe;
import com.mendix.restapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/categories/")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping( method = RequestMethod.GET)
    // @ApiOperation("Gets the product with speRecipecific id")
    // @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Product.class)})
    public List<Category> getCategoryAll() {
        System.out.println("here");
        return categoryService.getCategoryAll();
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    // @ApiOperation("Gets the product with specific id")
    // @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Product.class)})
    public Optional<Category> getRecipe(@PathVariable(name = "id") String id) {
        return categoryService.getCategory(id);
    }
}
