package com.mbis.shoppingcart.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mbis.shoppingcart.beans.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
