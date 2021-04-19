package com.training.springboot.productmanager.repository;

import com.training.springboot.productmanager.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
