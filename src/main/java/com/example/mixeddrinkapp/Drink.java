package com.example.mixeddrinkapp;

public class Drink {
	private long id;
	private String drink;
	private String ingredients;

	public Drink(long id, String drink, String ingredients) {
		this.id = id;
		this.drink = drink;
		this.ingredients = ingredients;
	}

	public long getId() {
		return id;
	}

	public String getDrink() {
		return drink;
	}
	
	public String getIngredients() {
		return ingredients;
	}
	
}