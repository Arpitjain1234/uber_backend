package com.example.uber.repository;

import com.example.uber.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {

}
