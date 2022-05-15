package com.springboot.resortmanagement.service;

import com.springboot.resortmanagement.dto.CustomerDto;
import com.springboot.resortmanagement.dto.ResortDto;
import com.springboot.resortmanagement.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(int theId);

    void save(Customer theCustomer);

    public void deleteById(int theId);

    List<Customer> findCustomers(int theId);

    List<CustomerDto> getAllCustomers();
}
