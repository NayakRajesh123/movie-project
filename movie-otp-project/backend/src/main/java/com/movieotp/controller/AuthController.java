package com.movieotp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.movieotp.service.AuthService;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired private AuthService authService;

    @PostMapping("/send-otp")
    public ResponseEntity<?> sendOtp(@RequestBody Map<String,String> body) {
        String phone = body.get("phone");
        if (phone == null) return ResponseEntity.badRequest().body("phone required");
        String code = authService.sendOtp(phone);
        // for demo we return code so frontend can show it (remove in production)
        return ResponseEntity.ok(Map.of("message","OTP sent","otp",code));
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestBody Map<String,String> body) {
        String phone = body.get("phone");
        String otp = body.get("otp");
        if (phone == null || otp == null) return ResponseEntity.badRequest().body("phone and otp required");
        boolean ok = authService.verifyOtp(phone, otp);
        if (ok) return ResponseEntity.ok(Map.of("message","verified"));
        return ResponseEntity.status(401).body(Map.of("message","invalid or expired otp"));
    }
}
