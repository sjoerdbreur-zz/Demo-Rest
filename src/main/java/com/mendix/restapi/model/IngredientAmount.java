package com.mendix.restapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
public class IngredientAmount {
    @Id
    private Long id;


    @NotNull
    @Positive
    private int quantity;

    //@NotNull
   // @Size(min=2, message="Unit should have atleast 2 characters")
    private String unit;
   /* @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "ingAmount")
    private Ingredient ing;
*/
    public IngredientAmount() {
    }

    public IngredientAmount(Long id, int quantity, String unit) {
        this.id = id;
        this.quantity = quantity;
        this.unit = unit;
        //this.ing = ing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

   /* public Ingredient getIng() {
        return ing;
    }

    public void setIng(Ingredient ing) {
        this.ing = ing;
    }*/
}
