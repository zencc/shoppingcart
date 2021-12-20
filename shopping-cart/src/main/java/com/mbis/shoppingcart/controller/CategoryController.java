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
import com.mbis.shoppingcart.beans.Category;
import com.mbis.shoppingcart.repository.CategoryRepository;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryRepository repository;
	
	@GetMapping("/category")
	public List<Category> getAllCategory(){
		return repository.findAll();
	}
	
	//GET
	@GetMapping("/category/{id}")
	public Category getCategoryDetails(@PathVariable long id) {
		Optional<Category> category = repository.findById(id);
		if(category.isEmpty()) {
			throw new RuntimeException("Category not found by with id "+id);
		}
		return category.get();
	}
	
	//POST
	@PostMapping("/category/add")
	public void createCategory(@RequestBody Category category) {
		repository.save(category);
	}
	
	//PUT
	@PutMapping("/category/{id}")
	public void updateCategory(@PathVariable long id,@RequestBody Category category) {
		repository.save(category);
	}
	
	//DELETE
	@DeleteMapping("/category/{id}")
	public void deleteCategory(@PathVariable long id) {
		repository.deleteById(id);
	}
}