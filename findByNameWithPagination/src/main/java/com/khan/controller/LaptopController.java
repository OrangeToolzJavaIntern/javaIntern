package com.khan.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.khan.entity.Laptop;
import com.khan.repos.LaptopRepository;

@RestController
public class LaptopController {

	@Autowired
	LaptopRepository lRepo;

	@GetMapping("/laptopbyname/{name}")
	public ResponseEntity<List<Laptop>> getLaptopsByName(@PathVariable String name) {
		return new ResponseEntity<List<Laptop>>(lRepo.findByName(name), HttpStatus.OK);
	}

	@GetMapping("/laptopsbybrand/{brand}")
	public ResponseEntity<List<Laptop>> getLaptopsByBrand(@PathVariable String brand) {
		return new ResponseEntity<List<Laptop>>(lRepo.findByBrand(brand), HttpStatus.OK);
	}

	@GetMapping("/laptopsbyprice/{price}")
	public ResponseEntity<List<Laptop>> getLaptopsByPrice(@PathVariable int price) {
		return new ResponseEntity<List<Laptop>>(lRepo.findByPrice(price), HttpStatus.OK);
	}

	@GetMapping("/laptops/price")
	public ResponseEntity<Map<String, Object>> getAllLaptops(@RequestParam(required = false) String brand,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {

		try {
			List<Laptop> laptop = new ArrayList<Laptop>();
			Pageable paging = PageRequest.of(page, size);

			Page<Laptop> pageTuts;
			if (brand == null)
				pageTuts = lRepo.findAll(paging);
			else
				pageTuts = lRepo.findByAllBrand(brand, paging);

			laptop = pageTuts.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("laptops", laptop);
			response.put("currentPage", pageTuts.getNumber());
			response.put("totalItems", pageTuts.getTotalElements());
			response.put("totalPages", pageTuts.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
