package com.example.uber.services;


import com.example.uber.entity.Rider;
import com.example.uber.entity.User;

public interface RegistrationService<T> {
    void register(T entity, String password);


}

