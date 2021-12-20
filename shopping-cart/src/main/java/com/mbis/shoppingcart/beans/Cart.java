package com.mbis.shoppingcart.beans;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cart {

	@Id
	@GeneratedValue
	private long cartId;
	
	private int quantity;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="productId")
	private Product product;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "cart")
	private Set<Orders> order;
	
	public Cart() {
	}
	
	public Cart(long cartId, int quantity) {
		super();
		this.cartId = cartId;
		this.quantity = quantity;
	}

	public long getCartId() {
		return cartId;
	}
	public int getQuantity() {
		return quantity;
	}	
}