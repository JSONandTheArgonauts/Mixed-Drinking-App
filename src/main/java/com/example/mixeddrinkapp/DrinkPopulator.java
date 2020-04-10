package com.example.mixeddrinkapp;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;

public class DrinkPopulator implements CommandLineRunner {
	
	@Resource
	private DrinkRepository drinkRepo;
	
	@Resource
	private LiquorRepository liquorRepo;
	
	@Resource
	private MixerRepository mixerRepo;

	@Resource
	private GarnishRepository garnishRepo;

	@Override
	public void run(String... args) throws Exception {
		
		//Liquors listed here
		Liquor vodkaPlain = new Liquor("Vodka", "Plain", true);
		vodkaPlain = liquorRepo.save(vodkaPlain);
		Liquor burbonPlain = new Liquor("Burbon", "Plain", false);
		burbonPlain = liquorRepo.save(burbonPlain);
		Liquor ginPlain = new Liquor("Gin", "Plain", true);
		ginPlain = liquorRepo.save(ginPlain);
		
		//Mixers listed here
		Mixer orangeJuice = new Mixer("Orange Juice", true);
		orangeJuice = mixerRepo.save(orangeJuice);
		Mixer tonicWater = new Mixer("Tonic Water", true);
		tonicWater = mixerRepo.save(tonicWater);
		Mixer bitters = new Mixer("Bitters", true);
		bitters = mixerRepo.save(bitters);
		
		//Garnish listed here
		Garnish cherry = new Garnish("Cherry", true);
		cherry = garnishRepo.save(cherry);
		Garnish lime = new Garnish("Lime Slice", true);
		lime = garnishRepo.save(lime);
		Garnish orange = new Garnish("Orange Slice", true);
		orange = garnishRepo.save(orange);
		
		//Finished Drinks Listed here (Name, Liquor 1 2 3, Mixer 1 2 3, Garnish 1 2 3)
		Drink screwdriver = new Drink("ScrewDriver", "Vodka", "", "", "Orange Juice", "", "", "Orange Slice", "", "");
		screwdriver = drinkRepo.save(screwdriver);
		Drink oldFasioned = new Drink("Old Fasioned", "Burbon", "", "", "Bitters", "", "", "Orange Slice", "Cherry", "");
		oldFasioned = drinkRepo.save(oldFasioned);
		Drink ginAndTonic = new Drink("Gin and Tonic", "Gin", "", "", "Tonic Water", "", "", "Lime Slice", "", "");
		ginAndTonic = drinkRepo.save(ginAndTonic);
		
	}
	
}

