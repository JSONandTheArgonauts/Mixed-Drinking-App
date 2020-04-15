package com.example.mixeddrinkapp;

import java.util.Collection;
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
    private Set<Recipe> drinks;

    protected Liquor(){}

    public Liquor(String liquorName) {
        this.name = liquorName;
        drinks = new HashSet<>();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Liquor liquor = (Liquor) o;
        return Objects.equals(name, liquor.name) &&
                Objects.equals(id, liquor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
