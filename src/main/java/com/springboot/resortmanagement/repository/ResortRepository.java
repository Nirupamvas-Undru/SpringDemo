package com.springboot.resortmanagement.repository;

import com.springboot.resortmanagement.entity.Resort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResortRepository extends JpaRepository<Resort, Integer> {
    // no code required
}
