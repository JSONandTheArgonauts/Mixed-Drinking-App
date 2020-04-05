package com.example.mixeddrinkapp;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Liquor {

	@Id
	@GeneratedValue
	private Long liquorId;

	private String name;
	private boolean inStock;

	@ManyToMany(mappedBy = "liquors")
	private Collection<Drink> drinks;

	public void setDrinks(Collection<Drink> drinks) {
		this.drinks = drinks;
	}

	// default constructor
	public Liquor() {
	}

	public Liquor(String name, boolean inStock) {
		this.name = name;
		this.inStock = inStock;
	}

	public String getName() {

		return name;
	}

	public boolean getInStock() {

		return inStock;
	}

	public Long getId() {

		return liquorId;
	}

}
