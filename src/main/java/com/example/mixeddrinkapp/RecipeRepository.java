package com.example.mixeddrinkapp;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

	Collection<Recipe> findByLiquors(Liquor liquorName);

	Collection<Recipe> findByMixers(Mixer mixerName);
	
	public void findAllByLiquorsContains(Liquor liquor);
}
