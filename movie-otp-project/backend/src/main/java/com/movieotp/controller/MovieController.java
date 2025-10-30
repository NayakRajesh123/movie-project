package com.movieotp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.movieotp.repository.MovieRepository;
import com.movieotp.model.Movie;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin
public class MovieController {

    @Autowired private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> all() {
        return movieRepository.findAll();
    }

    @PostMapping
    public Movie add(@RequestBody Movie m) {
        return movieRepository.save(m);
    }
}
