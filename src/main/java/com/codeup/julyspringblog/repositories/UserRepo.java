package com.codeup.julyspringblog.repositories;

import com.codeup.julyspringblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
