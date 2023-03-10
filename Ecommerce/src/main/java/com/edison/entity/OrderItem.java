package com.edison.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderItem {
	
	@Id
	private int id;
	
	private int quantity;
	
	private double price;
	
	private int userId;
	
	@ManyToOne
	private Product product;
	
	
	
		

	
	
	

}
