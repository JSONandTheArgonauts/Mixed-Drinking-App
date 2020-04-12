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
	private String flavor;
	private boolean inStock;

	public Liquor(String name, String flavor, boolean inStock) {
		this.name = name;
		this.flavor = flavor;
		this.inStock = inStock;
	}

	

	// default constructor
	public Liquor() {
	}

	public String getName() {

		return name;
	}

	public String getFlavor() {

		return flavor;
	}

	public boolean getInStock() {

		return inStock;
	}

	public Long getId() {

		return liquorId;
	}

	
}
