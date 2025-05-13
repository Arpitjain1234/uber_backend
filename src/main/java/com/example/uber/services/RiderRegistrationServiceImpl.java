package com.example.uber.services;

import com.example.uber.entity.Rider;
import com.example.uber.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RiderRegistrationServiceImpl  implements RegistrationService<Rider> {

    private final RiderRepository riderRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public RiderRegistrationServiceImpl(RiderRepository riderRepository,BCryptPasswordEncoder passwordEncoder) {
        this.riderRepository = riderRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(Rider rider, String password) {
        String hashedPassword = passwordEncoder.encode(password);
        rider.setPassword(hashedPassword);
        riderRepository.save(rider);

    }



}
