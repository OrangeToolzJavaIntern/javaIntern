package com.khan.springboot.repos;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.khan.springboot.entity.Laptop;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class LaptopRepositoryTest {

	@Autowired
	private LaptopRepository laptopRepository;
	
	
	
	
	@Test
	@Rollback(false)
	void addEntry() {
		 Laptop laptop = new Laptop(12, "Apple M1 Pro1", "New laptop1", "App1", 100);
		 laptopRepository.save(laptop);
		 
	}
	
	@Test
	void findByPrice() {
		int price = 100;
		
		Laptop laptop = laptopRepository.findByPrice(price);
		assertThat(laptop.getPrice()).isEqualTo(price);
		
		 
	}
	
	@Test
	void findByBrand() {
		String brand = "App1";
		
		Laptop laptop = laptopRepository.findByBrand(brand);
		assertThat(laptop.getBrand()).isEqualTo(brand);
	}
	
	@Test
	void findByName() {
		String name = "Apple M1 Pro1";
		
		Laptop laptop = laptopRepository.findByName(name);
		assertThat(laptop.getName()).isEqualTo(name);
	}

}
