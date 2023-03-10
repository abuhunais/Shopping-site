package com.edison.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edison.entity.CartItem;

public interface CartItemRepo extends JpaRepository<CartItem,Long> {

	List<CartItem> findByCartId(Long id);

}
