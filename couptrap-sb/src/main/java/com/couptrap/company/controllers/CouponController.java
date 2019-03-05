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


import com.couptrap.company.models.Coupon;

import com.couptrap.company.repositories.CouponRepository;

@RestController
@RequestMapping("/api/v1/coupon")
public class CouponController {
	@Autowired
	private CouponRepository couponRepository;
	
	
	@GetMapping
	public List<Coupon> list() {
		return couponRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Coupon coupon) {	
		System.out.println(coupon.getTitle());
		couponRepository.save(coupon);
	}

	@GetMapping("/{id}")
	public Coupon get(@PathVariable("id") long id) {
		return couponRepository.getOne(id);
	}
}
