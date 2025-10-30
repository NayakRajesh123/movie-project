package com.movieotp.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.movieotp.repository.UserRepository;
import com.movieotp.repository.OtpRepository;
import com.movieotp.model.User;
import com.movieotp.model.OTP;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired private UserRepository userRepository;
    @Autowired private OtpRepository otpRepository;
    @Autowired private OtpGenerator otpGenerator;
    @Autowired private TwilioService twilioService;

    public String sendOtp(String phone) {
        String code = otpGenerator.generateOtp();
        OTP otp = OTP.builder().phone(phone).code(code).expiry(LocalDateTime.now().plusMinutes(5)).build();
        otpRepository.deleteByPhone(phone);
        otpRepository.save(otp);
        twilioService.sendSms(phone, "Your MovieApp OTP: " + code);
        return code;
    }

    public boolean verifyOtp(String phone, String code) {
        Optional<OTP> o = otpRepository.findByPhoneAndCode(phone, code);
        if (o.isPresent() && o.get().getExpiry().isAfter(LocalDateTime.now())) {
            // create user if not exists
            userRepository.findByPhone(phone).orElseGet(() -> {
                User u = User.builder().phone(phone).name("User" + phone).role("ROLE_USER").build();
                return userRepository.save(u);
            });
            otpRepository.deleteByPhone(phone);
            return true;
        }
        return false;
    }
}
