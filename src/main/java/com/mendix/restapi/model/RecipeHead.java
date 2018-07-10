package com.mendix.restapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
public class RecipeHead implements Serializable {

    @Id
   //@GeneratedValue(strategy = GenerationType.SEQUENCE) // , generator = "system-uuid")
   // @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @NotNull
    @Column(unique = true)
    @Size(min=5, message="Recipe Title name should have atleast 5 characters")
    private String title;

    @Positive
    private int yield;

    @OneToOne(fetch = FetchType.LAZY,
                cascade =  CascadeType.ALL,
                mappedBy = "recipeHead")
     private Recipe recipe;

    @ManyToMany(fetch = FetchType.LAZY,  cascade =  CascadeType.ALL)
    @NotNull
    private List<Category> categories;

    public RecipeHead() { }
    public RecipeHead(String title, int yield) {
        this.title = title;
        this.yield = yield;
    }


    public RecipeHead(String id, String title, int yield, Recipe recipe) {
        this.id = id;
        this.title = title;
        this.yield = yield;
        this.recipe = recipe;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYield() {
        return yield;
    }

    public void setYield(int yield) {
        this.yield = yield;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
