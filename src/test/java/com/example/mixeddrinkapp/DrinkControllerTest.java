package com.example.mixeddrinkapp;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class DrinkControllerTest {
	
	@InjectMocks
	private DrinkController underTest;
	
	@Mock
	private Drink drink;
	
	@Mock
	private Drink anotherDrink;
	
	@Mock
	private DrinkRepository drinkRepo;
	
	
	@Mock
	private Liquor liquor;
	
	@Mock
	private Liquor anotherLiquor;
	
	@Mock
	private LiquorRepository liquorRepo;
	
	@Mock
	private Mixer mixer;
	
	@Mock
	private Mixer anotherMixer;
	
	@Mock
	private MixerRepository mixerRepo;
	
	@Mock
	private Garnish garnish;
	
	@Mock
	private Garnish anotherGarnish;
	
	@Mock
	private GarnishRepository garnishRepo;
	
	@Mock
	private Model model;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldAddSingleDrinkToModel() {
		long drinkId = 1L;
		when(drinkRepo.findById(drinkId)).thenReturn(Optional.of(drink));
		
		underTest.findOneDrink(drinkId, model);
		verify(model).addAttribute("drinks", drink);
	}
	
	@Test
	public void shouldAddAllDrinksToModel() {
		Collection<Drink> allDrinks = Arrays.asList(drink, anotherDrink);
		when(drinkRepo.findAll()).thenReturn(allDrinks);
		
		underTest.findAllDrinks(model);
		verify(model).addAttribute("drinks", allDrinks);
	}
	
	@Test
	public void shouldAddSingleLiquorToModel() {
		long liquorId = 1L;
		when(liquorRepo.findById(liquorId)).thenReturn(Optional.of(liquor));
		
		underTest.findOneLiquor(liquorId, model);
		verify(model).addAttribute("liquors", liquor);
	}
	
	@Test
	public void shouldAddAllLiquorsToModel() {
		Collection<Liquor> allLiquors = Arrays.asList(liquor, anotherLiquor);
		when(liquorRepo.findAll()).thenReturn(allLiquors);
		
		underTest.findAllLiquors(model);
		verify(model).addAttribute("liquors", allLiquors);
	}
	
	@Test
	public void shouldAddSingleMixerToModel() {
		long mixerId = 1L;
		when(mixerRepo.findById(mixerId)).thenReturn(Optional.of(mixer));
		
		underTest.findOneMixer(mixerId, model);
		verify(model).addAttribute("mixers", mixer);
	}
	
	@Test
	public void shouldAddAllMixersToModel() {
		Collection<Mixer> allMixers = Arrays.asList(mixer, anotherMixer);
		when(mixerRepo.findAll()).thenReturn(allMixers);
		
		underTest.findAllMixers(model);
		verify(model).addAttribute("mixers", allMixers);
	}
	
	@Test
	public void shouldAddSingleGarnishToModel() {
		long garnishId = 1L;
		when(garnishRepo.findById(garnishId)).thenReturn(Optional.of(garnish));
		
		underTest.findOneGarnish(garnishId, model);
		verify(model).addAttribute("garnishes", garnish);
	}
	
	@Test
	public void shouldAddAllGarnishesToModel() {
		Collection<Garnish> allGarnishes = Arrays.asList(garnish, anotherGarnish);
		when(garnishRepo.findAll()).thenReturn(allGarnishes);
		
		underTest.findAllGarnishes(model);
		verify(model).addAttribute("garnishes", allGarnishes);
	}
	
	@Test
	public void shouldAddAddtionalLiquorToModel() {
		String liquorName = "new liquor";
		Boolean liquorInStock = true;
		underTest.addLiquor(liquorName, liquorInStock);
		Liquor newLiquor = new Liquor(liquorName, liquorInStock);
		when(liquorRepo.save(newLiquor)).thenReturn(newLiquor);
	}
	

}
