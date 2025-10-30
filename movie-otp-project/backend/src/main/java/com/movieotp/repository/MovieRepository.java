package com.movieotp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movieotp.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
