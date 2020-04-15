package com.example.mixeddrinkapp;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
	
}
