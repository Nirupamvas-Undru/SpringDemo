package com.springboot.resortmanagement.service;

import com.springboot.resortmanagement.dto.ResortDto;
import com.springboot.resortmanagement.entity.Resort;

import java.util.List;

public interface ResortService {

    public List<Resort> findAll();

    public Resort findById(int theId);

    public void save(Resort theResort);

    public void deleteById(int theId);

    List<ResortDto> getAllResorts();
}
