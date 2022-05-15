package com.springboot.resortmanagement.controller;

import com.springboot.resortmanagement.dto.ResortDto;
import com.springboot.resortmanagement.entity.Resort;
import com.springboot.resortmanagement.service.ResortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// to get db data in JSON format
//@RestController

@Controller
@RequestMapping("/resorts")
public class ResortController {

    private ResortService resortService;


    String resortForm="resorts/resort-form";

    @Autowired
    public ResortController(ResortService theresortService) {
        resortService = theresortService;
    }

    @GetMapping("/showAll")
    public String findAll(Model theModel) {
        List<Resort> resorts = resortService.findAll();
        theModel.addAttribute("resorts", resorts);
        return "resorts/showResorts";
    }

    @GetMapping("/viewResorts")
    public String viewAll(Model theModel) {
        List<Resort> resorts = resortService.findAll();
        theModel.addAttribute("resorts", resorts);
        return "resorts/showResorts";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Resort theResort = new Resort();
        theModel.addAttribute("resort", theResort);
        return resortForm;
    }

    @PostMapping("/save")
    public String saveResort(@Valid @ModelAttribute("resort") Resort theResort, BindingResult result) {

        if(result.hasErrors()){
            return resortForm;
        }else{
            resortService.save(theResort);
            return "redirect:/resorts/showAll";
        }}

    @GetMapping("/showFormForUpdate")
    public String updateResort(@RequestParam("resortId") int theId, Model theModel) {
        Resort theResort = resortService.findById(theId);
        theModel.addAttribute(theResort);
        return resortForm;
    }

    @GetMapping("/deleteById")
    public String deleteResort(@RequestParam("resortId") int theId) {
        resortService.deleteById(theId);
        return "redirect:/resorts/showAll";
    }

    //for dto testing
    @GetMapping("/resort-list")
    public List<ResortDto> getAllResorts(){
        return resortService.getAllResorts();
    }
}
