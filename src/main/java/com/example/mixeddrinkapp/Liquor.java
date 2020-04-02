package com.example.mixeddrinkapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Liquor {

	
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private boolean inStock;
	
//	default constructor
	public Liquor() {}

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

	

}
