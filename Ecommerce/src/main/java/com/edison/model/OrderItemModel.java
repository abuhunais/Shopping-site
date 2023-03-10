package com.edison.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemModel {
	
	private String productName;
	
	private int quantity;
	
	private double price;
	
	private Long productId;
	
	private Long orderId;

}
