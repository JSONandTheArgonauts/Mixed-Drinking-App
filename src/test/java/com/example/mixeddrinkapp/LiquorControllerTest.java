package com.example.mixeddrinkapp;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.example.controller.LiquorController;

public class LiquorControllerTest {
	
	@InjectMocks
	private LiquorController underTest;
	
	@Mock
	private Liquor liquor;
	
	@Mock
	private Liquor anotherLiquor;
	
	@Mock
	private LiquorRepository liquorRepo;
	
	@Mock
	private Model model;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldAddSingleLiquorToModel() {
		Long liquorId = 1L;
		when(liquorRepo.findById(liquorId)).thenReturn(Optional.of(liquor));
		
		underTest.findOneLiquor(liquorId, model);
		verify(model).addAttribute("liquors", liquor);
	}

}
