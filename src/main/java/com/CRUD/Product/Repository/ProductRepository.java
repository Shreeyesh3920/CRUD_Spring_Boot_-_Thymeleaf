package com.CRUD.Product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRUD.Product.Entity.*;

public interface ProductRepository extends JpaRepository<Products, Long>{
		
	
}
