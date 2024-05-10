package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.repositories.PartRepository;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *
 *
 *
 *
 */
@Controller
public class AddPartController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showPartFormForUpdate")
    public String showPartFormForUpdate(@RequestParam("partID") int theId,Model theModel){

        PartService repo=context.getBean(PartServiceImpl.class);
        OutsourcedPartService outsourcedrepo=context.getBean(OutsourcedPartServiceImpl.class);
        InhousePartService inhouserepo=context.getBean(InhousePartServiceImpl.class);

        boolean inhouse=true;
        List<OutsourcedPart> outsourcedParts=outsourcedrepo.findAll();
        for(OutsourcedPart outsourcedPart:outsourcedParts) {
            if (outsourcedPart.getId() == theId) {
                inhouse = false;
                break;
            }
        }
        String formtype;
        if(inhouse){
            InhousePart inhousePart=inhouserepo.findById(theId);
            theModel.addAttribute("inhousepart",inhousePart);
            formtype="InhousePartForm";
        }
        else{
            OutsourcedPart outsourcedPart=outsourcedrepo.findById(theId);
            theModel.addAttribute("outsourcedpart",outsourcedPart);
            formtype="OutsourcedPartForm";
        }

        return formtype;

    }

    @GetMapping("/deletepart")
    public String deletePart(@Valid @RequestParam("partID") int theId,  Model theModel){
        PartService repo = context.getBean(PartServiceImpl.class);
        Part part=repo.findById(theId);
        if(part.getProducts().isEmpty()){
            repo.deleteById(theId);
            return "confirmationdeletepart";
        }
        else{
            return "negativeerror";
        }
    }

    @PostMapping("/updatePart")
    public String updatePart(@Valid @ModelAttribute("part") Part part, BindingResult result, Model theModel) {
        // Check for validation errors
        if (result.hasErrors()) {
            // Add the BindingResult containing validation errors to the model
            theModel.addAttribute("org.springframework.validation.BindingResult.part", result);
            return "InhousePartForm"; // Return the form view to display validation errors
        }

        // Validate inventory against minimum and maximum
        if (part.getInv() < part.getMinInv()) {
            result.rejectValue("inv", "error.inv", "Inventory cannot be lower than the minimum inventory");
            return "InhousePartForm";
        }

        if (part.getInv() > part.getMaxInv()) {
            result.rejectValue("inv", "error.inv", "Inventory cannot be higher than the maximum inventory");
            return "InhousePartForm";
        }
        return "redirect:/showPartFormForUpdate";
    }



}
