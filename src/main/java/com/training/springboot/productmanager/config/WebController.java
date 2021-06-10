package com.training.springboot.productmanager.config;

import com.training.springboot.productmanager.entity.Customer;
import com.training.springboot.productmanager.entity.CustomerModel;
import com.training.springboot.productmanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Controller
public class WebController {
    @Autowired
    CustomerService customerService;

    @GetMapping(value = {"/", "/home"})
    public ModelAndView customers(@RequestParam("s") Optional<String> s,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size) {
        ModelAndView modelAndView = new ModelAndView("/products");
//        Iterable<Customer> customers = customerService.getAll();
        Pageable pageable = PageRequest.of(page, size);
        Page<Customer> customerList;
        if (s.isPresent()) {
            customerList = customerService.findAllByCustomerNameContaining(s.get(), pageable);
        } else {
            customerList = customerService.findAll(pageable);
        }
        modelAndView.addObject("customers", customerList);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("customer", customerService.getCustomerById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute("customer") CustomerModel customer) throws ParseException {
        customerService.update(customer);
        return "redirect:/";
    }
}
