package com.training.springboot.productmanager.service;

import com.training.springboot.productmanager.entity.Customer;
import com.training.springboot.productmanager.entity.CustomerModel;
import com.training.springboot.productmanager.repository.CustomerRepository;
import com.training.springboot.productmanager.service.Impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CustomerService implements CustomerServiceImpl {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer save(CustomerModel model) throws ParseException {
        Customer cus = new Customer();
        cus.setStoreId(model.getStoreId());
        cus.setCustomerName(model.getCustomerName());
        cus.setDescription(model.getDescription());
        cus.setDossierId(model.getDossierId());
        cus.setCifNo(model.getCifNo());
        cus.setCaseId(model.getCaseId());
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(model.getDateCreate());
        cus.setDateCreate(date1);
        Customer result = customerRepository.save(cus);
        return result;
    }

    @Override
    public Customer update(CustomerModel model) throws ParseException {
        Optional<Customer> customer = customerRepository.findById(model.getId());
        if (!customer.isPresent()) {
            return customerRepository.save(customer.get());
        } else {
            customer.get().setCaseId(model.getCaseId());
            customer.get().setStoreId(model.getStoreId());
            customer.get().setCustomerName(model.getCustomerName());
            customer.get().setCifNo(model.getCifNo());
            customer.get().setDescription(model.getDescription());
            customer.get().setDossierId(model.getDossierId());
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(model.getDateCreate());
            customer.get().setDateCreate(date1);
            return customerRepository.save(customer.get());
        }
    }

    @Override
    public List<Customer> getCustomerByCaseId(String caseId) {
        List<Customer> result = customerRepository.findByCaseId((String) caseId);
        return result;
    }

    @Override
    public Optional<Customer> getById(Integer Id) {
        Optional<Customer> result = customerRepository.findById((Integer) Id);
        return result;
    }

    @Override
    public List<Customer> sortCustomer() {
        List<Customer> result = customerRepository.sortById();
        return result;
    }

    @Override
    public CustomerModel getCustomerById(Integer id) {
        Optional<Customer> result = customerRepository.findById(id);
        CustomerModel customer = new CustomerModel();
        if (result.isPresent()) {
            customer.setCaseId(result.get().getCaseId());
            customer.setCifNo(result.get().getCifNo());
            customer.setCustomerName(result.get().getCustomerName());
            String date = convertDateToString(result.get().getDateCreate());
            customer.setDateCreate(date);
            customer.setDescription(result.get().getDescription());
            customer.setDossierId(result.get().getDossierId());
            customer.setStoreId(result.get().getStoreId());
            customer.setId(result.get().getId());
        }
        return customer;
    }

    @Override
    public Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    public static String convertDateToString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String format = formatter.format(date);
        System.out.println(format);
        return format;
    }
}
