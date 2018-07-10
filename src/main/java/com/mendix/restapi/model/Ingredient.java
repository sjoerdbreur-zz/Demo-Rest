package com.mendix.restapi.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Ingredient {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)//, generator = "system-uuid")
   // @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private Long id;
    private String items;

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade =  CascadeType.ALL)
    @JoinColumn(name = "id",referencedColumnName = "id",nullable = false)
    private IngredientAmount ingAmount ;

    private String ingId;

    public String getIngId() {
        return ingId;
    }

    public void setIngId(String ingId) {
        this.ingId = ingId;
    }

    public Long getId() {
        return id;
    }


   public void setId(Long id) {
        this.id = id;
    }
    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public IngredientAmount getIngAmount() {
        return ingAmount;
    }

    public void setIngAmount(IngredientAmount ingAmount) {
        this.ingAmount = ingAmount;
    }
}
