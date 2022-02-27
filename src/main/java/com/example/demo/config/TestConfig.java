package com.example.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.Entities.Category;
import com.example.demo.Entities.Order;
import com.example.demo.Entities.User;
import com.example.demo.Entities.enums.OrderStatus;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category((Long)null, "Eletronics");
		Category cat2 = new Category((Long)null, "Foods");
		Category cat3 = new Category((Long)null, "Books");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		User u1 = new User((Long) null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User((Long) null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
			Order o1 = new Order((Long)null, Instant.parse("2019-06-20T19:53:072"),OrderStatus.CANCELED, u1);
			Order o2 = new Order((Long)null, Instant.parse("2019-04-20T18:52:062"),OrderStatus.DELIVERED, u1);
			Order o3 = new Order((Long)null, Instant.parse("2018-02-20T10:00:052"),OrderStatus.PAID, u2);
			
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
	
	
	
}
