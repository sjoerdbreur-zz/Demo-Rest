package com.mendix.restapi.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Category {

    @Id
    @Size(min=2, message="Category name should have atleast 2 characters")
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }
    //@ManyToMany(mappedBy = "categories")
    //private List<RecipeHead> recipeHeads;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* public List<RecipeHead> getRecipeHeads() {
        return recipeHeads;
    }

    public void setRecipeHeads(List<RecipeHead> recipeHeads) {
        this.recipeHeads = recipeHeads;
    }*/
}
