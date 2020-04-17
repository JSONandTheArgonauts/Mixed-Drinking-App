package com.example.mixeddrinkapp;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Mixer{
    private String name;
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany(mappedBy = "mixers")
    private Set<Recipe> drinks;
    private boolean inStock;
    
    protected Mixer(){}

    public Mixer(String mixerName) {
        drinks = new HashSet<>();
        this.name = mixerName;
        inStock = false;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Set<Recipe> getDrinks() {
        return drinks;
    }
    
    public void restock() {
        inStock = true;
    }
    public void markOutOfStock(){
        inStock = false;
    }

    public boolean isInStock() {
        return inStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mixer mixer = (Mixer) o;
        return Objects.equals(name, mixer.name) &&
                Objects.equals(id, mixer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
