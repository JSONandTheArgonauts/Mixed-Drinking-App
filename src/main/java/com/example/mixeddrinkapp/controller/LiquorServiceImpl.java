//package com.example.mixeddrinkapp.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.mixeddrinkapp.Liquor;
//import com.example.mixeddrinkapp.LiquorRepository;
//
//@Service("liquorServiceImpl")
//public class LiquorServiceImpl {
//
//	@Autowired
//	LiquorRepository liquorRepo;
//	
//	@Override
//	public void insertNewLiquor(Liquor newLiquor) {
//		if (liquorRepo.existsById(newLiquor.getId())) {
//			throw new LiquorFoundException();
//		}
//		liquorRepo.save(newLiquor);
//	}
//}
