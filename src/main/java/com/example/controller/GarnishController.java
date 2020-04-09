package com.example.controller;

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
		model.addAttribute("garnishes", garnish.get());
		return ("garnish");
	}

	@RequestMapping("show-garnishes")
	public String findAllGarnishes(Model model) {
		model.addAttribute("garnishes", garnishRepo.findAll());
		return ("garnishes");

	}
}
