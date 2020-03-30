package com.example.mixeddrinkapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MixerTest {

	Mixer underTest = new Mixer("name", true);
	
	@Test
	public void shouldReturnName() {
		String check = underTest.getName();
		assertEquals(check, "name");
	}
	
	@Test
	public void shouldBeInStock() {
		boolean check = underTest.inStock();
		assertTrue(check);
	}
}
