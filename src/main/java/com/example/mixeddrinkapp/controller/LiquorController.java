package com.example.mixeddrinkapp.controller;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mixeddrinkapp.Liquor;
import com.example.mixeddrinkapp.LiquorRepository;

@Controller
public class LiquorController {

	@Resource
	private LiquorRepository liquorRepo;

	@RequestMapping("/show-liquor")
	public String findOneLiquor(@RequestParam(value = "id") long Id, Model model) {
		Optional<Liquor> liquor = liquorRepo.findById(Id);
		model.addAttribute("liquorsModel", liquor.get());
		return ("ingredients");

	}

	@RequestMapping("/show-ingredients")
	public String findAllLiquors(Model model) {
		model.addAttribute("liquorsModel", liquorRepo.findAll());
		return ("ingredients");

	}

	@RequestMapping("/add-liquor")
	public String addLiquor(String liquorName, String liquorFlavor, Boolean liquorInStock) {
		Liquor newLiquor = liquorRepo.findByName(liquorName);

		if (newLiquor == null) {
			newLiquor = new Liquor(liquorName, liquorFlavor, liquorInStock);
			liquorRepo.save(newLiquor);
		}
		return "redirect:/show-liquors";
	}
}
