package com.example.mixeddrinkapp;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class IngredientsPopulator implements CommandLineRunner {
	
	@Resource
	private LiquorRepository liquorRepo;
	
	@Resource
	private MixerRepository mixerRepo;

	@Resource
	private GarnishRepository garnishRepo;
	
	public Liquor liquor;

	@Override
	public void run(String... args) throws Exception {
		
		//Liquors listed here
		Liquor vodka = new Liquor("Vodka");
		if (vodka.getInStock() == true) {
		vodka = liquorRepo.save(vodka);
		}
		Liquor burbonPlain = new Liquor("Burbon");
		burbonPlain = liquorRepo.save(burbonPlain);
		Liquor ginPlain = new Liquor("Gin");
		ginPlain = liquorRepo.save(ginPlain);
		Liquor whiskeyPlain = new Liquor("Whiskey");
		whiskeyPlain = liquorRepo.save(whiskeyPlain);
		
		//Mixers listed here
		Mixer orangeJuice = new Mixer("Orange Juice");
		orangeJuice = mixerRepo.save(orangeJuice);
		Mixer tonicWater = new Mixer("Tonic Water");
		tonicWater = mixerRepo.save(tonicWater);
		Mixer bitters = new Mixer("Bitters");
		bitters = mixerRepo.save(bitters);
		
//		//Garnish listed here
//		Garnish cherry = new Garnish("Cherry", true);
//		cherry = garnishRepo.save(cherry);
//		Garnish lime = new Garnish("Lime Slice", true);
//		lime = garnishRepo.save(lime);
//		Garnish orange = new Garnish("Orange Slice", true);
//		orange = garnishRepo.save(orange);
		
		
	}
	
}

