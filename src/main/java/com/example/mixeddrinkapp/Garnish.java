package com.example.mixeddrinkapp;

public class Garnish {
	private Long id;
	private String name;
	private String flavor;
	private String amount;
	
	
	public Garnish(Long id, String name, String flavor, String amount) {
		this.id = id;
		this.name = name;
		this.flavor = flavor;
		this.amount = amount;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getFlavor() {
		return flavor;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAmount() {
		return amount;
	}
	
	
}
