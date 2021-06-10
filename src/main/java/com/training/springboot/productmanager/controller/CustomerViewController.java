package com.training.springboot.productmanager.controller;

import com.training.springboot.productmanager.entity.Customer;
import com.training.springboot.productmanager.entity.CustomerModel;
import com.training.springboot.productmanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api")
public class CustomerViewController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/list")
    public ModelAndView customers() {
        ModelAndView modelAndView = new ModelAndView("/products");
        List<Customer> customers = customerService.getAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

}
