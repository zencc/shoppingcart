package com.mbis.shoppingcart.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mbis.shoppingcart.beans.Orders;
import com.mbis.shoppingcart.repository.OrdersRepository;

@RestController
public class OrdersController {
	
@Autowired
	private OrdersRepository repository;

	@GetMapping("/order")
	public List<Orders> getAllOrders(){
		return repository.findAll();
	}
	//POST
	@PostMapping("/order/{cartId}")
	public void createOrder(@PathVariable long cartId, @RequestBody Orders order) {
		repository.save(order);
	}
}