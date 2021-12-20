package com.mbis.shoppingcart.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mbis.shoppingcart.beans.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
