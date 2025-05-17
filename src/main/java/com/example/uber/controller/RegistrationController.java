package com.example.uber.controller;


import com.example.uber.entity.Rider;
import com.example.uber.entity.User;
import com.example.uber.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    @Qualifier("riderRegistration")
    RegistrationService<Rider> registrationService;

    @PostMapping("/rider")
    private void registerRider(Rider rider,String password){
        registrationService.register(rider,password);
    }

    @Autowired
    @Qualifier("userRegistration")
    RegistrationService<User> registrationServiceUser;

    @PostMapping("/user")
    private void registerUser(User user,String password){
        registrationServiceUser.register(user,password);
    }

}
