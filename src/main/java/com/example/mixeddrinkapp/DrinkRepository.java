package com.example.mixeddrinkapp;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface DrinkRepository extends CrudRepository<Drink, Long> {

	Collection<Drink> findByMixersContains(Mixer mixer);

}
