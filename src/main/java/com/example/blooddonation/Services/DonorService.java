package com.example.blooddonation.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blooddonation.Entities.Donor;
import com.example.blooddonation.Repositories.DonorRepository;

@Service
public class DonorService {

    @Autowired
    private DonorRepository donorRepository;

    public List<Donor> getAllDonors(){
        return donorRepository.findAll();
    }

    public Donor saveDonor(Donor donor){
        return donorRepository.save(donor);
    }

    public void deleteDonor(Long id){
        donorRepository.deleteById(id);
    }

    public Donor updateDonor(Long id, Donor updatedDonor){
        updatedDonor.setId(id);
        return donorRepository.save(updatedDonor);
    }
    
    public Donor getDonorById(Long id){
        return donorRepository.findById(id).orElse(null);
    }
}
