package com.example.mixeddrinkapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recipe {

	@Id
	@GeneratedValue
	private Long id;
	private String drinkName;
	private String liquor1;

//	@ManyToMany
//	private Collection<Recipe> liquors;

	public Recipe() {
	}

	public Recipe(String drinkName, String liquor1, String liquor2, String liquor3, String mixer1, String mixer2,
			String mixer3, String garnish1, String garnish2, String garnish3) {
		this.drinkName = drinkName;
		this.liquor1 = liquor1;
	}

	public Long getId() {

		return id;
	}

	public String getName() {

		return drinkName;
	}

	public String getLiquor1() {
		return liquor1;
	}

//	public Collection<Recipe> getLiquors() {
//
//		return liquors;
//	}

}
