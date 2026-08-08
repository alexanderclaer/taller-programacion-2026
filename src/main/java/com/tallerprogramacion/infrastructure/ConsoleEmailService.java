package com.tallerprogramacion.infrastructure;

import com.tallerprogramacion.application.EmailService;

public class ConsoleEmailService implements EmailService {
    @Override
    public void send(String email, String message) {
        System.out.println("Sending email to " + email + ": " + message);
    }
}