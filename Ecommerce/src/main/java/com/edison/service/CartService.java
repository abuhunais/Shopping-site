package com.edison.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edison.entity.Cart;
import com.edison.entity.CartItem;
import com.edison.model.CartItemModel;
import com.edison.repo.CartItemRepo;
import com.edison.repo.CartRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CartItemRepo cartItemRepo;

//	@Autowired
//	private OrderService orderService;

	public String addItemToCart(CartItemModel Item) {
		Cart cart = cartRepository.findByUserId(Item.getUserId());
		List<CartItem> cartItems = cartItemRepo.findByCartId(cart.getId());
		cart.setCartItems(cartItems);
		Double total = (double) 0;
		for (CartItem citem : cartItems) {
			total += citem.getProduct().getPrice();
		}
		cart.setTotalPrice(total);
		cartRepository.save(cart);

		return "Added Items sucessfully";
	}

	public List<CartItem> getallCartItems(int userId) {
		Cart cart = cartRepository.findByUserId(userId);
		List<CartItem> cartItems = new ArrayList<>();
		cartItems=cart.getCartItems();
		return cartItems;
	}

	public String proceedToCheckout(int userId) {
		Cart cart = cartRepository.findByUserId(userId);
		if (cart == null || cart.getCartItems() == null) {
			return "Cart is Empty";
		}
		cartRepository.deleteById(cart.getId());

		return "Cart Checkedout";
	}

	public void createCart(int userId) {
		Cart cart = new Cart();
		cart.setUserId(userId);
		cartRepository.save(cart);

	}

}
