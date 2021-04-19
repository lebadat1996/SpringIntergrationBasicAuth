package com.training.springboot.productmanager.service.Impl;

import com.training.springboot.productmanager.entity.*;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

public interface CustomerServiceImpl {
    List<Customer> getAll();

    Customer save(CustomerModel model) throws ParseException;

    Customer update(Customer customer);

    List<Customer> getCustomerByCaseId(String caseId);

}