package com.couptrap.company.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.couptrap.company.models.Comp;
import com.couptrap.company.repositories.CompRepository;

@RestController
@RequestMapping("/api/v1/comp")
public class CompController {
	@Autowired
	private CompRepository compRepository;
	
	
	@GetMapping
	public List<Comp> list() {
		return compRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Comp comp) {	
		System.out.println(comp.getName());
		compRepository.save(comp);
	}

	@GetMapping("/{id}")
	public Comp get(@PathVariable("id") long id) {
		return compRepository.getOne(id);
	}

}
