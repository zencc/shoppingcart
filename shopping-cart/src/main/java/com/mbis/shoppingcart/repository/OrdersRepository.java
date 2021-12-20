package com.mbis.shoppingcart.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mbis.shoppingcart.beans.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
