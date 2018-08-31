package com.cg.spring.plpmod21.service;

import java.util.Optional;

import com.cg.spring.plpmod21.beans.Cart;

public interface CartService {

	public Cart addToCart(int p_id);
	public String deleteFromCart(int p_id);
	public Iterable<Cart> getCartProducts();
	public boolean isAvailable(int p_id);
	public Optional<Cart> getCartProductById(int p_id);
	public Cart updateCart(Cart c);
	public Iterable<Cart> cartProducts(int p_id);
}
