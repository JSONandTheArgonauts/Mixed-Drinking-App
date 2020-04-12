package com.example.mixeddrinkapp;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RecipesPopulator implements CommandLineRunner {
	
	@Resource
	private RecipeRepository recipeRepo;

	@Override
	public void run(String... args) throws Exception {
		

		//Finished Drinks Listed here (Name, Liquor 1 2 3, Mixer 1 2 3, Garnish 1 2 3)
		Recipe screwdriver = new Recipe("ScrewDriver", "Vodka", "", "", "Orange Juice", "", "", "Orange Slice", "", "", "");
		screwdriver = recipeRepo.save(screwdriver);
		Recipe oldFasioned = new Recipe("Old Fasioned", "Burbon", "", "", "Bitters", "", "", "Orange Slice", "Cherry", "","");
		oldFasioned = recipeRepo.save(oldFasioned);
		Recipe ginAndTonic = new Recipe("Gin and Tonic", "Gin", "", "", "Tonic Water", "", "", "Lime Slice", "", "","");
		ginAndTonic = recipeRepo.save(ginAndTonic);
		
	}

}
