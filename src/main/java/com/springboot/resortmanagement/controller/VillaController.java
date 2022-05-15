package com.springboot.resortmanagement.controller;

import com.springboot.resortmanagement.dto.CustomerDto;
import com.springboot.resortmanagement.dto.VillaDto;
import com.springboot.resortmanagement.entity.Resort;
import com.springboot.resortmanagement.entity.Villa;
import com.springboot.resortmanagement.exception.ResortNotFoundException;
import com.springboot.resortmanagement.service.ResortService;
import com.springboot.resortmanagement.service.VillaService;
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
@RequestMapping("/villas")
public class VillaController {

    @Autowired
    private VillaService villaService;
    @Autowired
    public ResortService resortService;

    String villaForm= "villas/villa-form";


    @GetMapping("showAll")
    public String findAll(Model theModel){
        List<Villa> Villas= villaService.findAll();
        theModel.addAttribute("villas",Villas);
        return "villas/showVillas";
    }

    @GetMapping("/showFormForAdd/{Id}")
    public String showFormForAdd(Model theModel,@PathVariable int Id){
        Villa theVilla= new Villa();
        theModel.addAttribute("villa",theVilla);
        theModel.addAttribute("resortId",Id);
        return villaForm;
    }

    @PostMapping("/save/{Id}")
    public String saveVilla(@Valid @ModelAttribute("villa") Villa theVilla, BindingResult result, @PathVariable int Id){
        if(result.hasErrors()){
            return villaForm;
        }else {
            Resort theResort = resortService.findById(Id);
            theVilla.setResort(theResort);
            villaService.save(theVilla);
            return "redirect:/villas/findVillas?resortId=" + Id;
        }
    }

    @GetMapping("/showFormForUpdate")
    public String updateVilla(@RequestParam("villaId") int theId, @RequestParam("resortId") int Id , Model theModel){
        Villa theVilla = villaService.findById(theId);
        theModel.addAttribute(theVilla);
        theModel.addAttribute("resortId", Id);
        return villaForm;
    }

    @GetMapping("/deleteById")
    public String deleteVilla(@RequestParam("villaId") int theId,@RequestParam("resortId") int Id){
        villaService.deleteById(theId);
        return "redirect:/villas/findVillas?resortId="+Id;
    }

    @GetMapping("/findVillas")
    public String findVillas(@RequestParam("resortId") int theId, Model theModel){
        List<Villa> Villas=villaService.findVillas(theId);
       /* if(Villas.size()==0){
            throw new ResortNotFoundException("Resort id not found - " + theId);
        }*/
        theModel.addAttribute("resortVillas",Villas);
        theModel.addAttribute("resortId",theId);
        return "villas/showVillas";
    }


    @GetMapping("/viewVillas")
    public String viewVillas(@RequestParam("resortId") int theId, Model theModel){
        List<Villa> Villas=villaService.findVillas(theId);
        if(Villas.size()==0){
            throw new ResortNotFoundException("Resort id not found - " + theId);
        }
        theModel.addAttribute("resortVillas",Villas);
        theModel.addAttribute("resortId",theId);
        return "villas/showVillas";
    }

    //for dto testing
    @GetMapping("/villa-list")
    public List<VillaDto> getAllVillas(){
        return villaService.getAllVillas();
    }
}
