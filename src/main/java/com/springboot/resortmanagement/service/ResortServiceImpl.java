package com.springboot.resortmanagement.service;

import com.springboot.resortmanagement.dto.ResortDto;
import com.springboot.resortmanagement.entity.Resort;
import com.springboot.resortmanagement.repository.ResortRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ResortServiceImpl implements ResortService {

    @Autowired
    private ResortRepository resortRepository;

    @Autowired //(required = true)
    private ModelMapper modelMapper;


    @Override
    @Transactional
    public List<Resort> findAll() {
        return resortRepository.findAll();
    }

    @Override
    @Transactional
    public Resort findById(int theId) {
        Optional<Resort> result = resortRepository.findById(theId);

        Resort theResort = null;
        if(result.isPresent()){
            theResort = result.get();
        }else{
            throw new RuntimeException("The Resort with given ID " + theId + "is not present in the database");
        }
        return theResort;
    }

    @Override
    @Transactional
    public void save(Resort theResort) {
        resortRepository.save(theResort);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        resortRepository.deleteById(theId);
    }

    public List<ResortDto> getAllResorts() {
        return resortRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private ResortDto convertEntityToDto(Resort resort){
        ResortDto resortDto = new ResortDto();
        resortDto = modelMapper.map(resort,ResortDto.class);
        return resortDto;
    }
}
