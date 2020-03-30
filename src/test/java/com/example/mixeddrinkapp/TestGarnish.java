package com.example.mixeddrinkapp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest


public class TestGarnish {

	@Test
	public void shouldReturnId () {
		Garnish  one = new Garnish(1L, "", "", "");
		Garnish two = new Garnish(2L, "", "", "");
		
		Long result = one.getId();
		
		assertThat(1L, is(result));
	} 
	
	@Test
	public void shouldReturnFlavor () {
		Garnish  one = new Garnish(1L, "", "cherry", "");
		Garnish two = new Garnish(2L, "", "lemon", "");
		
		String result = one.getFlavor();
		
		assertThat("cherry", is(result));
	}
	
	@Test
	public void shouldReturnAmount() {
		Garnish  one = new Garnish(1L, "", "", "three");
		Garnish two = new Garnish(2L, "", "", "");
		
		String result = one.getAmount();
		
		assertThat("three", is(result));
	}
}
