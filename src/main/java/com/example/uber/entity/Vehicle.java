package com.example.uber.entity;

import com.example.uber.constants.VehicleEnum;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private VehicleEnum vehicleClass;
    private  String registrationNumber;
    private String brand;
    private  String model;
    private String yearOfMake;
    private  String color;
}
