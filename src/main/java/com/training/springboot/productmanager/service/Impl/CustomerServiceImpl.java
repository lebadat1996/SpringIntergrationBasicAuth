package com.training.springboot.productmanager.service.Impl;

import com.training.springboot.productmanager.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface CustomerServiceImpl {
    Iterable<Customer> getAll();

    Customer save(CustomerModel model) throws ParseException;

    Customer update(CustomerModel model) throws ParseException;

    List<Customer> getCustomerByCaseId(String caseId);

    Optional<Customer> getById(Integer id);

    List<Customer> sortCustomer();

    CustomerModel getCustomerById(Integer id);

    Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable);

    Page<Customer> findAll(Pageable pageable);
}
