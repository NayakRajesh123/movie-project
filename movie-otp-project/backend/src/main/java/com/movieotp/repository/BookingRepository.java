package com.movieotp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movieotp.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
