package com.cg.spring.plpmod21.controller;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.cg.spring.plpmod21.beans.Cart;
import com.cg.spring.plpmod21.beans.Product;
import com.cg.spring.plpmod21.service.CartService;
//import com.cg.spring.plpmod21.service.CartService;
import com.cg.spring.plpmod21.service.ProductService;

@RestController
public class ProductController {
	int ct,count = 1;
	BigDecimal sum;
	
	@Autowired
	ProductService service;
	@Autowired
	CartService serviceCart;
	

//	@RequestMapping("/image")
//	public Product uploadImage(@PathVariable("p_id") int p_id) {
//		//Product list = 
//				return service.getProdById(p_id).get();
//		//return new ModelAndView("image", "prod", list);
//	}
//	
//	@RequestMapping(value="/uploadimage/{p_id}", method = RequestMethod.GET)
//	public String addImage(@PathVariable("p_id") int p_id) {
//		
//		return "successImage";
//	}

	@RequestMapping("/getallproducts")
	public Iterable<Product> getAllProducts(){
		
		return service.getAllProducts(); 
		 	 }
	
	@RequestMapping(value = "/carting")
	public Cart addToCart(@RequestParam int p_id) {
		
		return serviceCart.addToCart(p_id);

		
	}
	
	
	private Iterable<Cart> getCartProducts() {
		// TODO Auto-generated method stub
		return serviceCart.getCartProducts(); 
	}

	@RequestMapping(value = "/showall")
	public Iterable<Cart> showAllCartProducts() {
	  return  serviceCart.getCartProducts();
		
	}
	
	@RequestMapping(value = "/delete")
	public void deleteCartProduct(@RequestParam int p_id) {

	serviceCart.deleteFromCart(p_id);
		
	}
	
	
	
	
	
	
}
