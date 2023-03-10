package com.edison.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CartModel {
	
	private Long id;

	private int userId;
	
	private Double totalPrice;

}
