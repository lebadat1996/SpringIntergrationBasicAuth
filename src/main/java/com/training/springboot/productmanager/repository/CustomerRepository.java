package com.training.springboot.productmanager.repository;

import com.training.springboot.productmanager.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT e FROM Customer e WHERE e.caseId = ?1")
    List<Customer> findByCaseId(String caseId);

    Customer findCustomerByID(Integer Id);

    @Query("SELECT e FROM Customer e order by e.ID asc ")
    List<Customer> sortById();
}
