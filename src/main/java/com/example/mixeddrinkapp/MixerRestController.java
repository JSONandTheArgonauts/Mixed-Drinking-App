package com.example.mixeddrinkapp;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mixers")
public class MixerRestController {
	
	@Resource
	private DrinkRepository drinkRepo;
	
	@Resource
	private MixerRepository mixerRepo;
	
	@RequestMapping("")
	public Iterable<Mixer> findAllMixers() {
		return mixerRepo.findAll();
	}
	
	@RequestMapping("/{id}")
	public Optional<Mixer> findOneMixer(@PathVariable long id) {
		return mixerRepo.findById(id);
	}
	
	@RequestMapping("/(mixerName)/drinks")
	public Collection<Drink> findAllDrinksByMixer(@PathVariable(value = "mixerName") String mixerName) {
		Mixer mixer = mixerRepo.findByNameIgnoreCase(mixerName);
		return drinkRepo.findByMixerContains(mixer);
	}

}
