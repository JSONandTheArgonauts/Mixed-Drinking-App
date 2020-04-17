package com.example.mixeddrinkapp;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Liquor{
    private String name;
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany(mappedBy = "liquors")
    private Set<Recipe> recipe;
    public Boolean inStock = false;
    
    protected Liquor(){}

    public Liquor(String liquorName) {
        this.name = liquorName;
        recipe = new HashSet<>();
        this.inStock = false;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
    
    public boolean getInStock() {
    	return inStock;
    }

    public Set<Recipe> getRecipe() {
        return recipe;
    }
    
    public void restock() {
       inStock = true;
    }
    public void markOutOfStock(){
        inStock = false;
    }
    public boolean isInStock(){
        return inStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Liquor liquor = (Liquor) o;
        return Objects.equals(name, liquor.name) &&
                Objects.equals(id, liquor.id) &&
                Objects.equals(inStock, liquor.inStock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inStock, name, id);
    }
}
