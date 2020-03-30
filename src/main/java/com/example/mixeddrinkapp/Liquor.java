package com.example.mixeddrinkapp;

public class Liquor {

	private Long id;
	private String name;
	private boolean inStock;

	public Liquor(Long id, String name, boolean inStock) {
		this.id = id;
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
