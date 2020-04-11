package com.example.mixeddrinkapp;

import org.springframework.data.repository.CrudRepository;

public interface LiquorRepository extends CrudRepository<Liquor, Long> {
	
	Liquor findByName(String liquorName);

//	public void insertNewLiquor(Liquor newLiquor) {
//		CrudRepository<Liquor, Long> liquorRepo;
//		if (liquorRepo.existsById(newLiquor.getId())) {
//			throw new LiquorFoundException();
//		}
//		liquorRepo.save(newLiquor);
//	}
}
