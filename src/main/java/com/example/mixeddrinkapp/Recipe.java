package com.example.mixeddrinkapp;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Recipe {

	@Id
	@GeneratedValue
	private Long id;
	private String drinkName;

//	default constructor
<<<<<<< HEAD:src/main/java/com/example/mixeddrinkapp/Drink.java
	public Drink() {
	}

	public Drink(String drinkName, String liquor1, String liquor2, String liquor3, String mixer1, String mixer2,
=======
	public Recipe() {}
	
	public Recipe(String drinkName, String liquor1, String liquor2, String liquor3, String mixer1, String mixer2,
>>>>>>> af5928bae91a0a0cf2c3a7169ae6aaf93652218f:src/main/java/com/example/mixeddrinkapp/Recipe.java
			String mixer3, String garnish1, String garnish2, String garnish3) {
		this.drinkName = drinkName;
	}

	public Long getId() {

		return id;
	}

	public String getName() {

		return drinkName;
	}

}
