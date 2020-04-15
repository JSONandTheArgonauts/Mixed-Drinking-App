package com.example.mixeddrinkapp;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
<<<<<<< HEAD
=======
	
	Recipe findByDrinkName(String drinkName);
	
	Collection<Recipe> findAllByOrderByDrinkNameAsc();
>>>>>>> parent of cdf3269... added mapping

}
