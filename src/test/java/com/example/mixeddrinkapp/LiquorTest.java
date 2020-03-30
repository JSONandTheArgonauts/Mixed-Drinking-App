package com.example.mixeddrinkapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LiquorTest {
	
	Liquor underTest = new Liquor(1L, "name", true);
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void shouldReturnId() {
		Long check = underTest.getId();
		equals(check = 1L);
	}
	
	@Test
	public void shouldReturnName() {
		String check = underTest.getName();
		assertEquals(check, "name");
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void shouldCheckIfInStock() {
		boolean check = underTest.getInStock();
		equals(check = true);
	}

}
