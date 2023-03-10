package com.edison.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edison.entity.Product;
import com.edison.model.ReviewModel;

public interface ReviewRepository extends JpaRepository<ReviewModel, Long>{
	
	List<ReviewModel> findByProduct(Product product);


}
