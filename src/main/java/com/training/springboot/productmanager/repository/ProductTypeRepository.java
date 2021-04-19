package com.training.springboot.productmanager.repository;

import com.training.springboot.productmanager.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

}
