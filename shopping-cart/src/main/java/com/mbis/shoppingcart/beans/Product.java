package com.mbis.shoppingcart.beans;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private long productId;
	
	private String name;
	private double price;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="categoryId")
	private Category category;
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy = "product")
	private Set<Cart> cart;
	
	public Product() {
	}

	public Product(long productId, String name, double price) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
	}

	public long getProductId() {
		return productId;
	}
	
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
}