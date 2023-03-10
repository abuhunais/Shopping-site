//package com.edison.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.edison.entity.Product;
//import com.edison.model.ReviewModel;
//import com.edison.repo.ProductRepository;
//import com.edison.repo.ReviewRepository;
//
//@Service
//public class ReviewService {
//	@Autowired
//	private ProductRepository productRepository;
//
//	@Autowired
//	private ReviewRepository reviewRepository;
//
////	public Review addProductReview(Long productId, Review review) {
////	    Optional<Product> productOptional = productRepository.findById(productId);
////	    if (!productOptional.isPresent()) {
////	        throw new IllegalArgumentException("Product not found with id " + productId);
////	    }
////	    Product product = productOptional.get();
////	    product.getReviews().add(review);
////	    review.setProduct(product);
////	    productRepository.save(product);
////	    return reviewRepository.save(review);
////	}
//
//	public ReviewModel updateProductCommentAndRating(Long reviewId, String comment, int rating) {
//	    Optional<ReviewModel> reviewOptional = reviewRepository.findById(reviewId);
//	    if (!reviewOptional.isPresent()) {
//	        throw new IllegalArgumentException("Review not found with id " + reviewId);
//	    }
//	    ReviewModel review = reviewOptional.get();
//	    review.setComment(comment);
//	    review.setRating(rating);
//	    return reviewRepository.save(review);
//	}
//
//
//	public List<ReviewModel> getProductReviews(Long productId) {
//	    Optional<Product> productOptional = productRepository.findById(productId);
//	    if (!productOptional.isPresent()) {
//	        throw new IllegalArgumentException("Product not found with id " + productId);
//	    }
//	    Product product = productOptional.get();
//	    return reviewRepository.findByProduct(product);
//	}
//}
//
