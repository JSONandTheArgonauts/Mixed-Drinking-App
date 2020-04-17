package com.example.mixeddrinkapp.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
	public String findAllIngredients(Liquor liquor, Mixer mixer, Model model) {
		model.addAttribute("liquorModel", liquorRepo.findAll());
		model.addAttribute("mixerModel", mixerRepo.findAll());
		model.addAttribute("garnishModel", garnishRepo.findAll());
		return ("ingredients");

	}
	
//	@RequestMapping("/show-recipes-by-ingredients")
//	public String findRecipesbyIngredient(String liquorName, String mixerName, Model model) {
//		Liquor liquor = liquorRepo.findByName(liquorName);
//		Mixer mixer = mixerRepo.findByName(mixerName);
//		model.addAttribute("recipeModel", recipeRepo.findByLiquors(liquor));
//		model.addAttribute("recipeModel", recipeRepo.findByMixers(mixer));
//		return ("recipes");
//	}
	
	@RequestMapping("/show-recipes-for-in-stock-items")
	public String findRecipesByIngredients(Model model) {
		Set<Recipe> recipes =new HashSet<>((List<Recipe>) recipeRepo.findAll());
		Set<Recipe> selectedRecipes = findAvailableRecipes(recipes);
		model.addAttribute("recipes" , selectedRecipes);
		return ("Recipes");
	}
	
	@RequestMapping("/show-avalible-recipes")
	private Set<Recipe> findAvailableRecipes(Set<Recipe> recipes) {
		HashSet<Recipe> availableRecipes = new HashSet<>();
		for(Recipe recipe :recipes) {
			boolean allLiquorsAvailable = true;
			for(Liquor liquor: recipe.getLiquors()) {
				if(!liquor.isInStock()) {
					allLiquorsAvailable = false;
				}
			}
			boolean allMixersAvailable = true;
			for (Mixer mixer: recipe.getMixers()) {
				if(!mixer.isInStock()) {
					allMixersAvailable = false;
				}
			}
			if(allLiquorsAvailable&&allMixersAvailable) {
				availableRecipes.add(recipe);
			}
		}
		return availableRecipes;
	}
}
