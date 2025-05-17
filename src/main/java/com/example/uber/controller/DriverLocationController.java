package com.example.uber.controller;

import com.example.uber.services.RiderLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rider")
public class DriverLocationController {

    @Autowired
    RiderLocationService riderLocationService;

    @PostMapping("/addLocation")
    public void addRider(
            @RequestParam String riderId,
            @RequestParam double riderLatitude,
            @RequestParam double riderLongitude){
        riderLocationService.addRiderLocation(riderId,riderLatitude,riderLongitude);


    }

    @GetMapping("/nearest")
    public List<String>findNearestRider(double userLatitude,double userLongitude,double radius ,int riderCount){
        return  riderLocationService.findNearestRiderFromUser(userLatitude,userLongitude,5.00,10);
    }

}
