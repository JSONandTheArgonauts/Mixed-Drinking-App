package com.example.mixeddrinkapp;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DrinkController {

	@Resource
	private DrinkRepository drinkRepo;

	@Resource
	private Drink drinkId;

	@Resource
	private LiquorRepository liquorRepo;

	@Resource
	private MixerRepository mixerRepo;

	@Resource
	private Mixer mixerId;

	@Resource
	private GarnishRepository garnishRepo;

	@Resource
	private Garnish garnishId;

	@RequestMapping("show-drink")
	public String findOneDrink(@RequestParam(value = "id") long id, Model model) {
		Optional<Drink> drink = drinkRepo.findById(id);
		model.addAttribute("drinks", drink.get());
		return ("drink");

	}

	@RequestMapping("show-drinks")
	public String findAllDrinks(Model model) {
		model.addAttribute("drinks", drinkRepo.findAll());
		return ("drinks");

	}

	@RequestMapping("show-mixer")
	public String findOneMixer(@RequestParam(value = "id") long id, Model model) {
		Optional<Mixer> mixer = mixerRepo.findById(id);
		model.addAttribute("mixers", mixer.get());
		return ("mixer");
	}

	@RequestMapping("show-mixers")
	public String findAllMixers(Model model) {
		model.addAttribute("mixers", mixerRepo.findAll());
		return ("mixers");

	}

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

	@RequestMapping("show-liquor")
	public String findOneLiquor(@RequestParam(value = "id") long Id, Model model) {
		Optional<Liquor> liquor = liquorRepo.findById(Id);
		model.addAttribute("liquors", liquor.get());
		return ("liquor");

	}

	@RequestMapping("show-liquors")
	public String findAllLiquors(Model model) {
		model.addAttribute("liquors", liquorRepo.findAll());
		return ("liquors");

	}

	@RequestMapping("/add-liquor")
	public String addLiquor(String liquorName, String liquorFlavor, Boolean liquorInStock) {
		Liquor newLiquor = liquorRepo.findByName(liquorName);
		
		if(newLiquor==null) {
			newLiquor = new Liquor(liquorName, liquorFlavor, liquorInStock);
			liquorRepo.save(newLiquor);
		}
		return "redirect:/show-liquors";
	}
	
	@RequestMapping("/add-garnish")
	public String addGarnish(String garnishName, Boolean garnishInStock) {
		Garnish newGarnish = garnishRepo.findByName(garnishName);
		
		if(newGarnish==null) {
			newGarnish = new Garnish(garnishName, garnishInStock);
			garnishRepo.save(newGarnish);
		}
		return "redirect:/show-garnishs";
	}
	
	@RequestMapping("/add-mixer")
	public String addMixer(String mixerName, Boolean mixerInStock) {
		Mixer newMixer = mixerRepo.findByName(mixerName);
		
		if(newMixer==null) {
			newMixer = new Mixer(mixerName, mixerInStock);
			mixerRepo.save(newMixer);
		}
		return "redirect:/show-mixers";
	}
	
}
