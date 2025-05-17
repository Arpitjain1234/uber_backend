package com.example.uber.services;

import com.example.uber.constants.RideStatus;
import com.example.uber.entity.*;
import com.example.uber.repository.RideRepository;
import com.example.uber.repository.RiderRepository;
import com.example.uber.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RideService {
    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private RiderRepository riderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired RiderLocationService riderLocationService;







    private void acceptRide(Location source , Location destination , Long userId, Long riderId, double fare){
        RideStatus rideStatus = RideStatus.ACCEPTED;
        Ride ride = new Ride(source,destination,riderId,userId,rideStatus,fare);
        String riderIdString  = riderId.toString();
        rideRepository.save(ride);
        riderLocationService.removeRiderFromAvailability(riderIdString);
    }

    private   void completeRide(Long rideId){
        Optional<Ride> optionalRide = rideRepository.findById(rideId);
        if(optionalRide.isPresent()){
            Ride ride  = optionalRide.get();
            ride.setRideStatus(RideStatus.COMPLETED);
            rideRepository.save(ride);
        }
        else{
            throw new RuntimeException("Ride not found with the give rideId :" +rideId);
        }

    }
    private void cancelRequest(Long rideId){
        Optional<Ride> optionalRide = rideRepository.findById(rideId);
        if(optionalRide.isPresent()){
            Ride ride  = optionalRide.get();
            ride.setRideStatus(RideStatus.CANCELLED);
            rideRepository.save(ride);
        }
        else{
            throw new RuntimeException("Ride not found with the give rideId :" +rideId);
        }

    }




}
