package com.example.mixeddrinkapp.controller;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mixeddrinkapp.*;

@Controller
public class RecipeController {
	
	@Resource
	private RecipeRepository recipeRepo;
	
	@Resource
	private LiquorRepository liquorRepo;

	@RequestMapping("/show-recipe")
	public String findOneRecipe(@RequestParam(value = "id") long id, Model model) {
		Optional<Recipe> recipe = recipeRepo.findById(id);
		model.addAttribute("recipeModel", recipe.get());
		return "recipe";

	}

	@RequestMapping("/show-recipes")
	public String findAllRecipes(Model model) {
		model.addAttribute("recipeModel", recipeRepo.findAll());
		return "recipes";

	}
	
	@RequestMapping("/show-ingredients")
	public String findAllLiquors(Model model) {
		model.addAttribute("liquorsModel", liquorRepo.findAll());
		return ("ingredients");

	}
}
