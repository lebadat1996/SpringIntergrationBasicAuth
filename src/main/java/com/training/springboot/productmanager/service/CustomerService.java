package com.training.springboot.productmanager.service;

import com.training.springboot.productmanager.entity.Customer;
import com.training.springboot.productmanager.entity.CustomerModel;
import com.training.springboot.productmanager.repository.CustomerRepository;
import com.training.springboot.productmanager.service.Impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements CustomerServiceImpl {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
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
        if (customer.isPresent()) {
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
        List<Customer> result = customerRepository.findAll();
        return result;
    }
}
