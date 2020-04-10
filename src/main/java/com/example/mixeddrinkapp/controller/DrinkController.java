package com.example.mixeddrinkapp.controller;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mixeddrinkapp.*;

@Controller
public class DrinkController {
	
	@Resource
	private DrinkRepository drinkRepo;

	@RequestMapping("/show-drink")
	public String findOneDrink(@RequestParam(value = "id") long id, Model model) {
		Optional<Drink> drink = drinkRepo.findById(id);
		model.addAttribute("drinksModel", drink.get());
		return "drink";

	}

	@RequestMapping("/show-drinks")
	public String findAllDrinks(Model model) {
		model.addAttribute("drinksModel", drinkRepo.findAll());
		return "drinks";

	}
}
