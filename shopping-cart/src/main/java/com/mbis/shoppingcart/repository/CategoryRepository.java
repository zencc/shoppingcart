package com.mbis.shoppingcart.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mbis.shoppingcart.beans.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
