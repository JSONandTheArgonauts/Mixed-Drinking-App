package com.example.mixeddrinkapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DrinkTest {
	
	Drink drinkTest = new Drink(5L, "GnT", "make it");

	@Test
	public void testReturnId() {
		Long testId = drinkTest.getId();
		testId.equals(new Long(5));
	}
	
	@Test
	public void testReturnName() {
		String testName = drinkTest.getDrink();
		assertEquals(testName , "GnT");
		
	}
	
	@Test
	public void testReturnIngredients() {
		String testIngredients = drinkTest.getIngredients();
		assertEquals(testIngredients , "make it");
	}

}
