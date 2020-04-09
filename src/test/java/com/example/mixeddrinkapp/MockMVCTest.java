package com.example.mixeddrinkapp;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.controller.DrinkController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(DrinkController.class)
public class MockMVCTest {

	@Resource
	private MockMvc mvc;

	@MockBean
	private DrinkRepository drinkRepo;

	@Mock
	private Drink drink;

	@Mock
	private Drink anotherDrink;
	
	@Test
	public void shouldRouteToAllDrinks() throws Exception {
		mvc.perform(get("/show-drinks")).andExpect(view().name(is("drinks")));
	}
}
