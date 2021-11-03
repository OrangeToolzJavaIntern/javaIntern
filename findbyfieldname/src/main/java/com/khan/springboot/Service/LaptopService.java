package com.khan.springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.khan.springboot.entity.Laptop;
import com.khan.springboot.repos.LaptopRepository;

public class LaptopService {
	
	@Autowired
	private LaptopRepository laptopRepository;
	
	public Laptop getLaptopByName(String name) {
		return laptopRepository.findByName(name);
	}

	public Laptop getLaptopByBrand(String brand) {
		return laptopRepository.findByBrand(brand);
	}  //findByPrice
	
	public Laptop getLaptopByPrice(int price) {
		return laptopRepository.findByPrice(price);
	}  

}
