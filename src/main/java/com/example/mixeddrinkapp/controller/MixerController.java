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
	
	@Resource
	private Mixer mixerId;

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
}
