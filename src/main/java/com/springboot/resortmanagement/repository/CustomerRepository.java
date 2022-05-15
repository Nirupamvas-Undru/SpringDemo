package com.springboot.resortmanagement.repository;

import com.springboot.resortmanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // no code required
    @Query(value="select * from customer where resort_resort_id=:resortId", nativeQuery=true)
    List<Customer> findCustomers(@Param("resortId") int theId);
}
