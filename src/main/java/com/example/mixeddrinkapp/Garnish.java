package com.example.mixeddrinkapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Garnish {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private boolean inStock;

//	default constructor
	public Garnish() {
	}

	public Garnish(String name, boolean inStock) {
		this.name = name;
		this.inStock = inStock;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean getInStock() {
		return inStock;
	}

}
