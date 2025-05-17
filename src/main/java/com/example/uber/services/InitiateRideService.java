package com.example.uber.services;

import com.example.uber.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitiateRideService {
    @Autowired
    RiderRepository riderRepository;

    RiderLocationService riderLocationService;

    public void sendRideRequestToRider(double userLatitude,double userLongitude){
        List<String> riderInCircle = riderLocationService.findNearestRiderFromUser(userLatitude,userLongitude,5,10);
        return;

    }

    // declare function to send notification to all the riders and once accepted remove the rider from the available riders 
}
