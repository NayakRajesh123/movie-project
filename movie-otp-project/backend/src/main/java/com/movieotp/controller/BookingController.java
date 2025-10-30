package com.movieotp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.movieotp.repository.BookingRepository;
import com.movieotp.repository.MovieRepository;
import com.movieotp.repository.UserRepository;
import com.movieotp.model.Booking;
import com.movieotp.model.User;
import com.movieotp.model.Movie;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin
public class BookingController {

    @Autowired BookingRepository bookingRepository;
    @Autowired UserRepository userRepository;
    @Autowired MovieRepository movieRepository;

    @PostMapping
    public Booking book(@RequestBody Map<String,String> body) {
        String phone = body.get("phone");
        Long movieId = Long.valueOf(body.get("movieId"));
        String seat = body.get("seat");
        User user = userRepository.findByPhone(phone).orElseThrow();
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        Booking b = Booking.builder()
                .user(user)
                .movie(movie)
                .seatNumber(seat)
                .bookingTime(LocalDateTime.now())
                .build();
        return bookingRepository.save(b);
    }
}
