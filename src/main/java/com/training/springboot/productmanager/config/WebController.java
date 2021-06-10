package com.training.springboot.productmanager.config;

import com.training.springboot.productmanager.entity.Customer;
import com.training.springboot.productmanager.entity.CustomerModel;
import com.training.springboot.productmanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;

@Controller
public class WebController {
    @Autowired
    CustomerService customerService;

    @GetMapping(value = {"/", "/home"})
    public ModelAndView customers() {
        ModelAndView modelAndView = new ModelAndView("/products");
        List<Customer> customers = customerService.getAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("customer", customerService.getById(id).get());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute("customer") CustomerModel customer) throws ParseException {
        customerService.save(customer);
        return "redirect:/";
    }
}
