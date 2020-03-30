package com.example.mixeddrinkapp;

public class Mixer {

	private String name;
	private boolean inStock;

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

}
