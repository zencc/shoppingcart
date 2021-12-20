package com.mbis.shoppingcart.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class Orders{

	@Id
	private long orderId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cartId",insertable=false, updatable=false)
	private Cart cart;

	private int quantity;
	private long productId;
	private String paymentMethod;
	private String deliveryMode;
	private String deliveryAddress;
	
	public Orders(long orderId, Cart cart, long cartId, String paymentMethod, String deliveryMode,
			String deliveryAddress) {
		super();
		this.orderId = orderId;
		this.cart = cart;
		this.quantity = cart.getQuantity();
		this.productId = cart.getCartId();
		this.paymentMethod = paymentMethod;
		this.deliveryMode = deliveryMode;
		this.deliveryAddress = deliveryAddress;
	}
	public long getOrderId() {
		return orderId;
	}
	public Cart getCart() {
		return cart;
	}
	public int getQuantity() {
		return quantity;
	}
	public long getProductId() {
		return productId;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public String getDeliveryMode() {
		return deliveryMode;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
}