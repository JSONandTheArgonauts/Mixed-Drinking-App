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
		Recipe whiteRussian = new Recipe("White Russian", "Vodka", "Coffee Liqueur", "", "Half and Half", "", "", "", "", "");
		whiteRussian = recipeRepo.save(whiteRussian);
		Recipe tomCollins = new Recipe("Tom Collins", "Gin", "", "", "Soda Water", "Lemon Juice", "", "Lemon Slice", "", "");
		tomCollins = recipeRepo.save(tomCollins);
		Recipe vodkaMartini = new Recipe("Vodka Martini", "Vodka", "Vermouth", "", "", "", "", "Olive", "", "");
		vodkaMartini = recipeRepo.save(vodkaMartini);
		Recipe cosmopolitan = new Recipe("Cosmopolitan", "Vodka", "Triple Sec", "", "Cranberry Juice", "Lime Juice", "", "Lime Slice", "", "");
		cosmopolitan = recipeRepo.save(cosmopolitan);
		Recipe sidecar = new Recipe("Sidecar", "Brandy", "Triple Sec", "", "Lemon Juice", "", "", "Lemon Slice", "", "");
		sidecar = recipeRepo.save(sidecar);
		Recipe pinaColada = new Recipe("Piña Colada", "White Rum", "", "", "Coconut Cream", "Pinapple Juice", "", "Pinapple Slice", "Cherry", "");
		pinaColada = recipeRepo.save(pinaColada);
		Recipe bloodyMary = new Recipe("Bloody Mary", "Vodka", "", "", "Tomato Juice", "Hot Sauce", "", "Celery", "", "");
		bloodyMary = recipeRepo.save(bloodyMary);
		Recipe manhattan = new Recipe("Manhattan", "Rye Whisky", "Vermouth", "", "Angostura bitters", "", "", "Cherry", "", "");
		manhattan = recipeRepo.save(manhattan);
	}

}
