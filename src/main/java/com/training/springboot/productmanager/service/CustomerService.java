package com.training.springboot.productmanager.service;

import ch.qos.logback.core.status.Status;
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
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public Customer getCustomerByCaseId(String caseId) {
        return null;
    }
}
