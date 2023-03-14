package com.edison.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edison.entity.Cart;
import com.edison.entity.CartItem;
import com.edison.entity.Product;
import com.edison.model.CartItemModel;
import com.edison.repo.CartItemRepo;
import com.edison.repo.CartRepository;
import com.edison.repo.ProductRepository;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	CartItemRepo cartItemRepo;
	
	@Autowired
	ProductRepository productRepository;

	public void AddCartItem(CartItemModel Item) {
		CartItem cartItem =new CartItem();
		Cart cart = cartRepository.findByUserId(Item.getUserId());
		if(cart!=null) {
			cartItem.setCart(cart);
		}else {
			Cart cartt = new Cart();
			cartt.setUserId(Item.getUserId());
			cartRepository.save(cartt);
			cartItem.setCart(cartt);
		}
		Optional<Product> product = productRepository.findById(Item.getProductId());
		if(product.isPresent())
			cartItem.setProduct(product.get());
		cartItem.setQuantity(Item.getQuantity());
		cartItemRepo.save(cartItem);
		
	}

}
