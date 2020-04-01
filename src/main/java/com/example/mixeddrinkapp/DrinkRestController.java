package com.example.mixeddrinkapp;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drinks")
public class DrinkRestController {

	@Resource
	private DrinkRepository drinkRepo;
	
	@Resource
	private MixerRepository mixerRepo;

	@RequestMapping("")
	public Iterable<Drink> findAllDrinks() {
		return drinkRepo.findAll();
	}

	@RequestMapping("/{id}")
	public Optional<Drink> findOneDrink(@PathVariable long id) {
		return drinkRepo.findById(id);
	}
	
	@RequestMapping("/mixers/(mixerName)")
	public Collection<Drink> findAllDrinksByMixer(@PathVariable(value = "mixerName") String mixerName) {
		Mixer mixer = mixerRepo.findByNameIgnoreCase(mixerName);
		return drinkRepo.findByMixersContains(mixer);
	}
}