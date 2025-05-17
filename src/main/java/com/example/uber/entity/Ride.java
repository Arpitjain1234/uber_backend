package com.example.uber.entity;

import com.example.uber.constants.RideStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "ride")
@Getter
@Setter
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "source_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "source_longitude"))
    })
    private Location sourceLocation;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "destination_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "destination_longitude"))
    })
    private Location destinationLocation;

    @NonNull
    @Column(name = "rider_id")
    private Long riderId;

    @NonNull
    @Column(name = "user_id")
    private Long userId;

    @Enumerated(EnumType.STRING)
    private RideStatus rideStatus;



    @NonNull
    @Column(name = "fare")
    private  double fare;



    public Ride(Location sourceLocation, Location destinationLocation, Long riderId, Long userId, RideStatus rideStatus, double ridefare){
        this.sourceLocation = sourceLocation;
        this.destinationLocation = destinationLocation;
        this.riderId = riderId;
        this.userId = userId;
        this.rideStatus = rideStatus;
        this.fare = ridefare;

    }



}
