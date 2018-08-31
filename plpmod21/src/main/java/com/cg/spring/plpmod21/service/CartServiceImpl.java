package com.cg.spring.plpmod21.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.plpmod21.beans.Cart;
import com.cg.spring.plpmod21.beans.Product;
import com.cg.spring.plpmod21.repo.CartRepo;

@Service
public class CartServiceImpl implements CartService {
	int ct, count = 1;
	@Autowired
	CartRepo repo;

	@Autowired
	ProductService service;


	@Override
	public String deleteFromCart(int p_id) {
		
		
		Iterable<Cart> list = getCartProducts();
		for (Cart cart : list) {
			if(cart.getP_id()==p_id) {
				int id = cart.getC_id();
				repo.deleteById(id);
				return "success";
			}
		}
		return "failed";
		
	}

	@Override
	public Iterable<Cart> getCartProducts() {

		return repo.findAll();
	}

	@Override
	public boolean isAvailable(int p_id) {
		return repo.existsById(p_id);
	}

	@Override
	public Cart updateCart(Cart c) {
		return repo.save(c);
	}

	@Override
	public Optional<Cart> getCartProductById(int p_id) {

		return repo.findById(p_id);

	}

	@Override
	public Iterable<Cart> cartProducts(int p_id) {

		return repo.findAll();
	}

	@Override
	public Cart addToCart(int p_id) {
		
		Optional<Product> prod = service.getProdById(p_id);
		Iterable<Cart> list = getCartProducts();
		Product pro = prod.get();
		for (Cart cart : list) {

			if (cart.getP_id() == p_id) {
				// c=serviceCart.getCartProductById(cart.getC_id()).get();
				count = cart.getP_quantity();
				count++;
				cart.setP_quantity(count);
				BigDecimal amount = cart.getCartAmount();
				cart.setCartAmount(amount.add(pro.getP_price()));
				return updateCart(cart);
				//return repo.save(cart);
			}

		}

		Cart c1 = new Cart();
		c1.setP_id(p_id);
		c1.setP_name(pro.getP_name());
		c1.setCartAmount(pro.getP_price());
		c1.setP_quantity(1);
		//serviceCart.addToCart(c1);
		 return repo.save(c1);
		
		
		
		//return repo.save(c);
	}

}
