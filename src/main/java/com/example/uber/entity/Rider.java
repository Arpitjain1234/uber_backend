package com.example.uber.entity;

import com.example.uber.constants.RiderActivity;

import java.util.Set;

public class Rider extends User
{

   private Set<Vehicle>vehicles;
   private Set<BankDetails>bankDetails;
   private RiderActivity currentActivity;

}
