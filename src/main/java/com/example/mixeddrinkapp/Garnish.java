package com.example.mixeddrinkapp;

public class Garnish {
	private Long id;
	private String name;
	private String amount;
	
	
	public Garnish(Long id, String name, String amount) {
		this.id = id;
		this.name = name;
		this.amount = amount;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAmount() {
		return amount;
	}
	
	
}
