package com.movieotp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movieotp.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPhone(String phone);
}
