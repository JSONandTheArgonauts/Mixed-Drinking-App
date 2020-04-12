package com.example.mixeddrinkapp.controller;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mixeddrinkapp.Mixer;
import com.example.mixeddrinkapp.MixerRepository;

@Controller
public class MixerController {

	@Resource
	private MixerRepository mixerRepo;

	@RequestMapping("show-mixer")
	public String findOneMixer(@RequestParam(value = "id") long id, Model model) {
		Optional<Mixer> mixer = mixerRepo.findById(id);
		model.addAttribute("mixersModel", mixer.get());
		return ("ingredients");
	}

	@RequestMapping("show-mixers")
	public String findAllMixers(Model model) {
		model.addAttribute("mixersModel", mixerRepo.findAll());
		return ("ingredients");

	}

	@RequestMapping("/add-mixer")
	public String addMixer(String mixerName) {
		Mixer newMixer = mixerRepo.findByName(mixerName);

		if (newMixer == null) {
			newMixer = new Mixer(mixerName, true);
			mixerRepo.save(newMixer);
		}
		return "redirect:/show-ingredients";
	}
}
