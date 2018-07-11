package com.mendix.restapi.model;

//import javax.persistence.;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;



@Entity
public class Recipe implements Serializable {

    @Id

    private String id;

    @Size(min=2, message="description should have atleast 20 characters")
    private String description;

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade =  CascadeType.ALL)
    @JoinColumn(name = "id",referencedColumnName = "id",nullable = false)
  //  @NotNull
    @Valid
    private RecipeHead recipeHead ;

    @OneToMany(fetch = FetchType.LAZY,  cascade =  CascadeType.ALL)
    @JoinColumn(name = "ingId",referencedColumnName = "id",nullable = false,insertable = false,updatable = false)
 //   @NotNull
    @Valid
    private List<Ingredient> ingredients;

    public Recipe() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RecipeHead getRecipeHead() {
        return recipeHead;
    }

    public void setRecipeHead(RecipeHead recipeHead) {
        this.recipeHead = recipeHead;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
