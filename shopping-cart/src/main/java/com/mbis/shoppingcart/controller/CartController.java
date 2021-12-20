package com.mbis.shoppingcart.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mbis.shoppingcart.beans.Cart;
import com.mbis.shoppingcart.repository.CartRepository;

@RestController
public class CartController {
	
	@Autowired
	private CartRepository repository;
	
	@GetMapping("/cart")
	public List<Cart> getAllCart(){
		return repository.findAll();
	}
	
	//POST
	@PostMapping("/cart")
	public void createCart(@RequestBody Cart cart) {
		repository.save(cart);
	}
}