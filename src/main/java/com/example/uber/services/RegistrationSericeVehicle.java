package com.example.uber.services;

import com.example.uber.entity.Vehicle;
import com.example.uber.repository.VehicleRepository;

public class RegistrationSericeVehicle {

    private final VehicleRepository vehicleRepository;

    public RegistrationSericeVehicle(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    public  void registerVehicle(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }

}
