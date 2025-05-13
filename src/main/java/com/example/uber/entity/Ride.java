package com.example.uber.entity;

import com.example.uber.constants.RideStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Entity
@Table(name = "ride")
@Getter
@Setter
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(name = "sourceLocation")
    
    private Location sourceLocation;
    private Location destinationLocation;
    private Rider rider;
    private User user;
    private RideStatus rideStatus;
    private Vehicle vehicle;



    Ride(Location sourceLocation,Location destinationLocation,Rider rider,User user,RideStatus rideStatus,Vehicle vehicle){
        this.sourceLocation = sourceLocation;
        this.destinationLocation = destinationLocation;
        this.rider = rider;
        this.user = user;
        this.rideStatus = rideStatus;
        this.vehicle = vehicle;

    }



}
