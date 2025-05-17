package com.example.uber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class RideRequestWebSocketController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;


}
