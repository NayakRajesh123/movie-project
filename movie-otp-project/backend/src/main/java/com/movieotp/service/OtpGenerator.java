package com.movieotp.service;

import org.springframework.stereotype.Component;
import java.security.SecureRandom;

@Component
public class OtpGenerator {
    private final SecureRandom random = new SecureRandom();

    public String generateOtp() {
        int num = 100000 + random.nextInt(900000);
        return String.valueOf(num);
    }
}
