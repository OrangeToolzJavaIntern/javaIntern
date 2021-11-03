package com.khan.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.khan.springboot.Service.LaptopService;
import com.khan.springboot.entity.Laptop;

@RestController
public class LaptopController {
	
	@Autowired
	LaptopService lservice;
	
	@GetMapping("/laptopbyname/{name}")
	public Laptop getLaptopsByName (@PathVariable String name) {
		
		return lservice.getLaptopByName(name);
	}
	
	@GetMapping("/laptopbybrand/{brand}")
	public Laptop getLaptopsByBrand (@PathVariable String brand) {
		return lservice.getLaptopByBrand(brand);
	}
	
	@GetMapping("/laptopbyprice/{price}")
	public Laptop getLaptopsByPrice (@PathVariable int price) {
		return lservice.getLaptopByPrice(price);
	}
	
}
