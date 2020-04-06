package com.example.mixeddrinkapp;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Drink {

	@Id
	@GeneratedValue
	private long drinkId;

	private String drinkName;

	private String liquor1;

	private String liquor2;

	private String liquor3;

	private String mixer1;

	private String mixer2;

	private String mixer3;

	private String garnish1;

	private String garnish2;

	private String garnish3;

	@ManyToMany
	private Collection<Liquor> liquors;

	// default constructor
	public Drink() {
	}

	public Drink(String drinkName, String liquor1, String liquor2, String liquor3, String mixer1, String mixer2,
			String mixer3, String garnish1, String garnish2, String garnish3) {
		this.drinkName = drinkName;
		this.liquor1 = liquor1;
		this.liquor2 = liquor2;
		this.liquor3 = liquor3;
		this.mixer1 = mixer1;
		this.mixer2 = mixer2;
		this.mixer3 = mixer3;
		this.garnish1 = garnish1;
		this.garnish2 = garnish2;
		this.garnish3 = garnish3;
	}

	public long getId() {
		return drinkId;
	}

	public String getName() {
		return drinkName;
	}

	public Collection<Liquor> getLiquors() {

		return liquors;
	}

	
}