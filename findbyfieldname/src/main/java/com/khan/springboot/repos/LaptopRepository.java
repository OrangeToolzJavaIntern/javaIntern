package com.khan.springboot.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khan.springboot.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
	
	public Laptop findByName(String name);
	
	public Laptop findByPrice(int price);
	
	public Laptop findByBrand(String brand);
	
}
