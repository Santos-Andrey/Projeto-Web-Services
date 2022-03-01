package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItemRepository, Long> {

	void saveAll(List<OrderItem> asList);


}
