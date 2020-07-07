package com.codeup.julyspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String postsIndex(){
        return "Display all posts...";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewPost(@PathVariable int id) {
        return "view a single post...";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostForm(){
        return "Display create post form";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String submitPost(){
        return "Creating new post...";
    }

}
