package com.edison.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;

import com.edison.entity.Cart;
import com.edison.entity.Order;
import com.edison.entity.OrderItem;
import com.edison.model.OrderModel;
import com.edison.repo.CartRepository;
import com.edison.repo.OrderItemRepository;
//import com.edison.model.SalesReport;
//import com.edison.repo.CustomerRepository;
import com.edison.repo.OrderRepository;
import com.edison.repo.ProductRepository;
//import com.edison.repo.ReportRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	OrderItemService orderItemService;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	@Autowired
	private ProductRepository productRepository;
//	@Autowired 
//	private CustomerRepository customerRepository;


//	@Autowired
//	private CustomerRepository customerRepository;
//	@Autowired
//	private ReportRepository reportRepository;
//	@Autowired
//	private ReportService reportService;


	public List<Order> getOrderHistory(int userId) {
		List<Order> orders = orderRepository.findByUserId(userId);
		return orders;
	}

	public String getOrderStatus(Long orderId) {
		 Order order = orderRepository.findById(orderId).orElseThrow();
		 return order.getStatus();
	}
	public String createOrder(OrderModel Item ) {
		Order order = new Order();
		order.setUserId(Item.getUserId());
		OrderItem orderItem = orderItemService.setOrderItem(Item) ;
		List<OrderItem> items = new ArrayList<>();
		items.add(orderItem);
		order.setOrderItems(items);
		order.setTotalPrice(orderItem.getPrice());
		order.setOrderDate(Item.getDate());
		orderRepository.save(order);
		return "order created";
	}
	
	
	public String createBulkOrder(Long CartId) {
		Order order = new Order();
		Optional<Cart> cart = cartRepository.findById(CartId);
		List<OrderItem> orderItems = orderItemService.setOrderItems(cart.get());
		order.setOrderItems(orderItems);
		order.setOrderDate("");
		double total = 0;
		for(OrderItem orditem : orderItems) {
			total+=orditem.getPrice();
		}
		order.setTotalPrice(total);
		order.setUserId(cart.get().getUserId());
		orderRepository.save(order);
		return "order created";
	}

}
