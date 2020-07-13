package com.codeup.julyspringblog.repositories;

import com.codeup.julyspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
}
