package com.training.springboot.productmanager.controller;

import com.training.springboot.productmanager.entity.Customer;
import com.training.springboot.productmanager.entity.CustomerModel;
import com.training.springboot.productmanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

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
    public ResponseEntity<List<Customer>> getAll() {
        List<Customer> listCustomer = customerService.getAll();
        return new ResponseEntity<List<Customer>>(listCustomer, HttpStatus.OK);
    }

//    @RequestMapping("/getCustomerByCaseId/{id}")
//    public ResponseEntity<Customer> getCustomerByCaseId(@PathVariable(name = "id") int id) {
//        return customerService.getCustomerByCaseId(i
//    }
}
