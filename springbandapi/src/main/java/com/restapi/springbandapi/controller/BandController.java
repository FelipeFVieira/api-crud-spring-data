package com.restapi.springbandapi.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.springbandapi.model.Band;
import com.restapi.springbandapi.repository.SpringDataRepository;



@RestController
@RequestMapping(path="/band")
public class BandController {
	
	@Autowired
	private SpringDataRepository SpringDataRepository;
	
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Band> getAllUsers() {
		return SpringDataRepository.findAll();
	}
	
	
}
