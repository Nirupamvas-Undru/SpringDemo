package com.springboot.resortmanagement.service;

import com.springboot.resortmanagement.dto.ResortDto;
import com.springboot.resortmanagement.dto.VillaDto;
import com.springboot.resortmanagement.entity.Villa;

import java.util.List;

public interface VillaService {

    public List<Villa> findAll();

    public Villa findById(int theId);

    public void save(Villa theVilla);

    public void deleteById(int theId);

    List<Villa> findVillas(int theId);

    List<VillaDto> getAllVillas();
}
