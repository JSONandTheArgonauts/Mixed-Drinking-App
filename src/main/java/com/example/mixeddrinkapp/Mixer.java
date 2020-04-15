package com.example.mixeddrinkapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mixer {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private boolean inStock;

//	default constructor
	public Mixer() {
	}

	public Mixer(String name, boolean inStock) {
		this.name = name;
		this.inStock = inStock;
	}

	public String getName() {

		return name;
	}

	public boolean inStock() {

		return inStock;
	}

	public Long getId() {

		return id;

	}

}
