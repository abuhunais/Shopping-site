package com.edison.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edison.entity.Cart;
import com.edison.entity.OrderItem;
import com.edison.entity.Product;
import com.edison.model.OrderModel;
import com.edison.repo.OrderItemRepository;
import com.edison.repo.ProductRepository;
@Service
public class OrderItemSeriviceImpl implements OrderItemService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	public OrderItem setOrderItem(OrderModel order) {
		OrderItem orderItem = new OrderItem();
		Optional<Product> product = productRepository.findById(order.getProductId());
		if(product.isPresent()){
			orderItem.setProductId(product.get());
			orderItem.setPrice(product.get().getPrice());
		}
		orderItem.setQuantity(order.getQuantity());
		orderItem.setUserId(order.getUserId());
		orderItemRepository.save(orderItem);
		return orderItem;
		
	}


	public List<OrderItem> setOrderItems(Cart cart) {
		List<OrderItem> items = new ArrayList<OrderItem>();
		
		
		return null;
	}

}
