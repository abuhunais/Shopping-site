package com.edison.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edison.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer>{

	List<OrderItem> findByUserId(Long userId);
	

}
