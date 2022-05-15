package com.springboot.resortmanagement.service;

import com.springboot.resortmanagement.dto.CustomerDto;
import com.springboot.resortmanagement.dto.VillaDto;
import com.springboot.resortmanagement.entity.Customer;
import com.springboot.resortmanagement.entity.Villa;
import com.springboot.resortmanagement.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired //(required = true)
    private ModelMapper modelMapper;


    @Override
    @Transactional
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public Customer findById(int theId) {
        Optional<Customer> result = customerRepository.findById(theId);
        Customer theCustomer = null;
        if(result.isPresent()) {
            theCustomer = result.get();
        }
        else {
            throw new RuntimeException("The Given Customer Id " + theId + "is not present");
        }
        return theCustomer;
    }

    @Override
    @Transactional
    public void save(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        customerRepository.deleteById(theId);
    }

    @Override
    @Transactional
    public List<Customer> findCustomers(int theId) {
        return customerRepository.findCustomers(theId);
    }

    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(this::convertEntityToDtoCustomer)
                .collect(Collectors.toList());
    }

    private CustomerDto convertEntityToDtoCustomer(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto = modelMapper.map(customer, CustomerDto.class);
        return customerDto;
    }
}
