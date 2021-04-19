package com.training.springboot.productmanager.controller;

import com.training.springboot.productmanager.entity.Customer;
import com.training.springboot.productmanager.entity.CustomerModel;
import com.training.springboot.productmanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<Customer> save(@RequestBody CustomerModel model) throws ParseException {
        Customer cus = customerService.save(model);
        return new ResponseEntity<Customer>(cus, HttpStatus.OK);
    }
    /* ---------------- GET ALL CUSTOMER ------------------------ */
    @PostMapping("/customers")
    public ResponseEntity<Customer> getdAll() {
        ResponseEntity<Customer> listCustomer = customerService.getAll();
        return new ResponseEntity<Customer>(listCustomer, HttpStatus.OK);
    }
}
