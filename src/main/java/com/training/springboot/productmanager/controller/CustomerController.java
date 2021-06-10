package com.training.springboot.productmanager.controller;


import com.training.springboot.productmanager.entity.Customer;
import com.training.springboot.productmanager.entity.CustomerModel;
import com.training.springboot.productmanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


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
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAll() {
        Iterable<Customer> listCustomer = customerService.getAll();
        List<Customer> result = new ArrayList<Customer>();
        listCustomer.forEach(result::add);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /* ---------------- GET CUSTOMER BY ID ------------------------ */
    @GetMapping("/getCustomerByCaseId")
    public ResponseEntity<List<Customer>> getCustomerByCaseId(@RequestParam String caseId) {
        List<Customer> listCustomerByCaseId = customerService.getCustomerByCaseId(caseId);
        return new ResponseEntity<List<Customer>>(listCustomerByCaseId, HttpStatus.OK);
    }

    /* ---------------- UPDATE CUSTOMER ------------------------ */
    @PostMapping("/updateCustomer")
    public ResponseEntity<Customer> update(@RequestBody CustomerModel model) throws ParseException {
        Customer customer = customerService.update(model);
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    /* ---------------- SORT CUSTOMER ------------------------ */
    @GetMapping("/sortCustomer")
    public ResponseEntity<List<Customer>> sortCustomer() {
        List<Customer> listCustomer = customerService.sortCustomer();
        return new ResponseEntity<List<Customer>>(listCustomer, HttpStatus.OK);
    }


}
