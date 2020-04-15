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
	
	@Resource
	private MixerRepository mixerRepo;
	
	@Resource
	private GarnishRepository garnishRepo;
	
	@RequestMapping("splash-page")
	public String showSplashPage(Model model) {
		return ("splash");
		
	}

	@RequestMapping("/show-recipe")
	public String findOneRecipe(@RequestParam(value = "id") long id, Model model) {
		Optional<Recipe> recipe = recipeRepo.findById(id);
		model.addAttribute("recipeModel", recipe.get());
		return ("recipe");

	}

	@RequestMapping("/show-recipes")
	public String findAllRecipes(Model model) {
		model.addAttribute("recipeModel", recipeRepo.findAll());
		return ("recipes");

	}
	
	@RequestMapping("/show-ingredients")
	public String findAllIngredients(Model model) {
		model.addAttribute("liquorModel", liquorRepo.findAll());
		model.addAttribute("mixerModel", mixerRepo.findAll());
		model.addAttribute("garnishModel", garnishRepo.findAll());
		return ("ingredients");

	}
	
	@RequestMapping("/show-recipes-by-ingredients")
	public String findRecipesbyIngredient(String liquorName, Model model) {
		Liquor liquor = liquorRepo.findByName(liquorName);
		model.addAttribute("recipes", recipeRepo.findByRecipeContains(liquor));
		for (int i=0; i <= 10; i++) {
			for(liquor = "recipes") {
				if ()
				
			}
		}
		}
}
