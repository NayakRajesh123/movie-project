package com.movieotp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movieotp.model.OTP;
import java.util.Optional;

public interface OtpRepository extends JpaRepository<OTP, Long> {
    Optional<OTP> findByPhoneAndCode(String phone, String code);
    void deleteByPhone(String phone);
}
