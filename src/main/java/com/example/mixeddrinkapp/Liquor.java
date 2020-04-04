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
	private Long id;

	private String name;
	private boolean inStock;

	@ManyToMany(mappedBy = "liquors")
	Collection<Drink> drinks;

	public Collection<Drink> getDrinks() {
		return drinks;
	}

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

		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drinks == null) ? 0 : drinks.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (inStock ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


}
