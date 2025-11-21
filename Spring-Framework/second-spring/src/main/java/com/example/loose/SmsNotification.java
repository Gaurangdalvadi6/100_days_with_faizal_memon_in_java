package com.example.loose;

import org.springframework.stereotype.Component;

@Component
public class SmsNotification implements NotificationService{
    @Override
    public void send(String message) {
        System.out.println("SMS : "+message);
    }
}
