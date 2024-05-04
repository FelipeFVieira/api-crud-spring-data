package com.restapi.springbandapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.springbandapi.model.Band;
import com.restapi.springbandapi.repository.SpringDataRepository;
import org.springframework.validation.annotation.Validated;


@RestController
@RequestMapping(path="/bands")
public class BandController {
	
	@Autowired
	private SpringDataRepository SpringDataRepository;
	
	
	@GetMapping(path="/all")
	public @ResponseBody ResponseEntity<Iterable<Band>> getAllUsers() {
		   try {
		        Iterable<Band> allBands = SpringDataRepository.findAll();
		        return ResponseEntity.ok(allBands);
		    } catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		    }
	}
	
	@PostMapping(path="/add")
	public @ResponseBody ResponseEntity<Band> addNewUser (@Validated @RequestBody Band band) {
		try {
	        Band savedBand = SpringDataRepository.save(band);
	        return ResponseEntity.ok(savedBand);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }
	}
	
	@DeleteMapping(path="/del/{id}")
	public @ResponseBody ResponseEntity<Band> deleteUser (@PathVariable int id) {
		Band band;
		Optional<Band> optionalUser = SpringDataRepository.findById(id);
		if (!optionalUser.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		
		band = optionalUser.get();
	    SpringDataRepository.delete(band);
		return ResponseEntity.ok(band);
	}
	
	@PutMapping(path="/update/{id}")
	public @ResponseBody ResponseEntity<Band> updateUser(@PathVariable int id, @RequestBody Band updatedBand) {
		Optional<Band> optionalBand = SpringDataRepository.findById(id);
	    if (!optionalBand.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    Band band = optionalBand.get();
	    band.setName(updatedBand.getName());
	    band.setRelease_year(updatedBand.getRelease_year());
	    band.setStatus(updatedBand.getStatus());

	    Band savedBand = SpringDataRepository.save(band);
	    return ResponseEntity.ok(savedBand);
		
	}
	
}
