package com.example.mixeddrinkapp;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class DrinksPopulator {

	@Resource
	private DrinkRepository drinkRepo;

	@Resource
	private LiquorRepository liquorRepo;

	@Resource
	private MixerRepository mixerRepo;

	public void run(String... args) throws Exception {

		Mixer mixers = new Mixer("mixer", true);
		mixers = mixerRepo.save(mixers);
		Liquor liquors = new Liquor(1L, "liquor", "", true);
		liquors = liquorRepo.save(liquors);

		Drink drink = new Drink("drink", liquors.getId(), null, null, mixers.getId(), null, null, null, null, null);

	}
}
