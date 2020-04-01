package com.example.mixeddrinkapp;

public class Liquor {

	private Long id;
	private String name;
	private String flavor;
	private boolean inStock;

	public Liquor(Long id, String name, String flavor, boolean inStock) {
		this.id = id;
		this.name = name;
		this.flavor = flavor;
		this.inStock = inStock;
	}

	public Long getId() {
		
		return id;
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

}
