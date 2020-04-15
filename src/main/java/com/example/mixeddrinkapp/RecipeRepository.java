package com.example.mixeddrinkapp;

import java.util.Collection;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
	
	Recipe findByDrinkName(String drinkName);
	
	Collection<Recipe> findAllByOrderByDrinkNameAsc();

	Set<Recipe> findAllByLiquorsContainsAndMixersContains(Liquor liquor, Mixer mixer);

}
