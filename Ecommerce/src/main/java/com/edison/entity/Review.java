package com.edison.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
	@Id 
	private int id;
	
	private String comment;

	private int rating;
	
	@ManyToOne
	private Product product;

}
