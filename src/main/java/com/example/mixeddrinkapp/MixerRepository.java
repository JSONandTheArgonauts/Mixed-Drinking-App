package com.example.mixeddrinkapp;

import org.springframework.data.repository.CrudRepository;

public interface MixerRepository extends CrudRepository<Mixer, Long> {

	Mixer findByNameIgnoreCase(String mixerName);

}
