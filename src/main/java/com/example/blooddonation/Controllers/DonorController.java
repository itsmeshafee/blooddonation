package com.example.blooddonation.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blooddonation.Entities.Donor;
import com.example.blooddonation.Services.DonorService;

import jakarta.annotation.Generated;

@Controller
// @RequestMapping("/donors")
public class DonorController {

    @Autowired
    private DonorService donorService;

    @GetMapping
    public String home(){
        return "Home.html";
    }

    @GetMapping("/donors")
    public String getAllDonors(Model model){
        List<Donor> donors = donorService.getAllDonors();
        model.addAttribute("donors", donors);
        return "Donors.html";
    }

    @GetMapping(value = "/donors/add")
    public String showAddDonorForm(Model model){
        model.addAttribute("donor", new Donor());
        return "AddDonor.html";
    }

    @PostMapping(value = "/donors/add")
    public String addDonor(@ModelAttribute Donor donor){
        donorService.saveDonor(donor);
        return "redirect:/donors";
    }

    @GetMapping("/donors/update/{id}")
    public String showUpdateDonorForm(@PathVariable Long id, Model model){
        Donor donor = donorService.getDonorById(id);
        model.addAttribute("donor", donor);
        return "UpdateDonor.html";        
    }

    @PostMapping("/donors/update/{id}")
    public String updateDonor(@PathVariable Long id, @ModelAttribute Donor updatedDonor){
        donorService.updateDonor(id, updatedDonor);
        return "redirect:/donors";
    }

    @GetMapping("/donors/delete/{id}")
    public String deleteDonor(@PathVariable Long id){
        donorService.deleteDonor(id);
        return "redirect:/donors";
    }
    
}
