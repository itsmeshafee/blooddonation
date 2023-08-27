package com.example.blooddonation.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Donor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    private String fName;

    private String lName;

    private String bloodGroup;

    private String email;

    private String contact;

    private String acontact;

//    private String country;

    private String state;

    private String city;
}
