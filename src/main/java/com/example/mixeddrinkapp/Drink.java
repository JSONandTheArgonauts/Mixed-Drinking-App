package com.example.mixeddrinkapp;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Drink {
	@Id
	@GeneratedValue
	private long id;

	private String name;
	private String mixers;
	private String garnish;

	@OneToMany
	private Collection<Liquor> liquors;

//	default constructor
	public Drink() {
	}

	public Drink(String name, String mixers, String garnish, Liquor... liquors) {
		this.name = name;
		this.liquors = new HashSet<>(Arrays.asList(liquors));
		this.mixers = mixers;
		this.garnish = garnish;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMixers() {
		return mixers;
	}

	public String getGarnish() {
		return garnish;
	}

	public Collection<Liquor> getLiquors() {

		return liquors;
	}

}