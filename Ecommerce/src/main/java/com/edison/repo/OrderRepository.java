package com.edison.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edison.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

	List<Order> findByOrderDateBetween(Date startDate, Date endDate);
	//double totalSales = orders.stream().mapToDouble(order -> order.getTotalAmount()).sum();

	List<Order> findByUserId(int userId);


}
