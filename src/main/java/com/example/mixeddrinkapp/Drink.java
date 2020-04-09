package com.example.mixeddrinkapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Drink {

	@Id
	@GeneratedValue
	private Long id;
	private String drinkName;
	
//	default constructor
	public Drink() {}

	public Drink(String drinkName, Object object, Object object2, Object object3, Object object4, Object object5,
			Object object6, Object object7, Object object8, Object object9) {
		this.drinkName = drinkName;
	}

	public Long getId() {
		
		return id;
	}

	public String getName() {
		
		return drinkName;
	}

}
