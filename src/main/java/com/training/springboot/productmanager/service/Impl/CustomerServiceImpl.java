package com.training.springboot.productmanager.service.Impl;

import com.training.springboot.productmanager.entity.*;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface CustomerServiceImpl {
    List<Customer> getAll();

    Customer save(CustomerModel model) throws ParseException;

    Customer update(CustomerModel model) throws ParseException;

    List<Customer> getCustomerByCaseId(String caseId);

    Optional<Customer> getById(Integer id);

    List<Customer> sortCustomer();
}
