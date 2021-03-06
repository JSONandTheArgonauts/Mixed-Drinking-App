package com.example.mixeddrinkapp.controller;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mixeddrinkapp.Garnish;
import com.example.mixeddrinkapp.GarnishRepository;

@Controller
public class GarnishController {
	
	@Resource
	private GarnishRepository garnishRepo;

	@RequestMapping("show-garnish")
	public String findOneGarnish(@RequestParam(value = "id") long id, Model model) {
		Optional<Garnish> garnish = garnishRepo.findById(id);
		model.addAttribute("garnishesModel", garnish.get());
		return ("ingredients");
	}

	@RequestMapping("show-garnishes")
	public String findAllGarnishes(Model model) {
		model.addAttribute("garnishesModel", garnishRepo.findAll());
		return ("ingerdients");

	}
	
	@RequestMapping("/add-garnish")
	public String addGarnish(String garnishName) {
		Garnish newGarnish = garnishRepo.findByName(garnishName);
		
		if(newGarnish==null) {
			newGarnish = new Garnish(garnishName, true);
			garnishRepo.save(newGarnish);
		}
		return "redirect:/show-ingredients";
	}
	
	@RequestMapping("/delete-garnish")
	public String deleteGarnishByName(String garnishName) {
		if (garnishRepo.findByName(garnishName) != null){
			Garnish deletedGarnish = garnishRepo.findByName(garnishName);
			garnishRepo.delete(deletedGarnish);
		}
		return "redirect:/show-ingredients";	
	}
}
