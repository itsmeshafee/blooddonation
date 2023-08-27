package com.example.blooddonation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blooddonation.Entities.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long> {
    
}
