package com.mbis.shoppingcart.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.mbis.shoppingcart.beans.Product;
import com.mbis.shoppingcart.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository repository;

	@GetMapping("/product")
	public List<Product> getProducts(){
		return repository.findAll();
	}

	//GET
	@GetMapping("/product/{id}")
	public Product getProductDetails(@PathVariable long id) {
		Optional<Product> product = repository.findById(id);
		if(product.isEmpty()) {
			throw new RuntimeException("Product not found by with id "+id);
		}
		return product.get();
	}
	
	//POST
	@PostMapping("/product/add")
	public void createProduct(@RequestBody Product product) {
		repository.save(product);
	}
	
	//PUT
	@PutMapping("/product/{id}")
	public void updateProduct(@PathVariable long id,@RequestBody Product product) {
		repository.save(product);
	}
	
	//DELETE
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable long id) {
		repository.deleteById(id);
	}
}