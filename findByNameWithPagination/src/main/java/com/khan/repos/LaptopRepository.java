package com.khan.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khan.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
	
	List<Laptop> findByName(String name);
	
	List<Laptop> findByPrice(int price);
	
	List<Laptop> findByBrand(String brand);
	
	Page<Laptop> findByAllBrand(String brand, Pageable pageable);
	
}
