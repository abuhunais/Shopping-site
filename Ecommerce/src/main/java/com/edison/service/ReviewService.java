package com.edison.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edison.entity.Product;
import com.edison.entity.Review;
import com.edison.entity.User;
import com.edison.model.ReviewModel;
import com.edison.repo.ProductRepository;
import com.edison.repo.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	public Review addProductReview(Long productId, Review review) {
	    Optional<Product> productOptional = productRepository.findById(productId);
	    if (!productOptional.isPresent()) {
	        throw new IllegalArgumentException("Product not found with id " + productId);
	    }
	    Product product = productOptional.get();
	    review.setUserId(review.getUserId());
	    product.getReviews().add(review);
	    review.setProdId(product);
	    productRepository.save(product);
	    return reviewRepository.save(review);
	}

	public Review updateProductCommentAndRating(Review review, Long productId, int id) {
		Product product = productRepository.findById(productId).orElseThrow(null);
		Review reviewOptional = reviewRepository.findById(id);
//		product.getReviews().add(reviewOptional);
		reviewOptional.setComment(review.getComment());
	    reviewOptional.setRating(review.getRating());
//	    reviewOptional.setProdId(review.getProdId());
//	    reviewOptional.setUserId(review.getUserId());
	    review.setProdId(product);
	    review.getUserId();
//	    productRepository.save(product);
	    Review updatedreview = reviewRepository.save(reviewOptional);
	    return updatedreview;
	}

	public List<Review> getProductReviews(Long productId) {
	    Optional<Product> productOptional = productRepository.findById(productId);
	    if (!productOptional.isPresent()) {
	        throw new IllegalArgumentException("Product not found with id " + productId);
	    }
	    //Product product = productOptional.get();
	    return reviewRepository.findById(productId);
	}
}

