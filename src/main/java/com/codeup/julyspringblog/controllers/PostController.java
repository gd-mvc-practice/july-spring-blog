package com.codeup.julyspringblog.controllers;

import com.codeup.julyspringblog.models.Post;
import com.codeup.julyspringblog.repositories.PostRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    private final PostRepo postDao;

    public PostController(PostRepo postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String getPosts(Model model){
        model.addAttribute("posts", postDao.findAll());
//this return is saying to return what shows up in the templates/posts/index.html
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable int id, Model model) {
        Post post1 = new Post(id, "My first post", "second string");
        model.addAttribute("title", post1.getTitle());
        model.addAttribute("body", post1.getBody());

//this return is saying to return what shows up in the templates/posts/show.html
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String getCreatePostForm(){

        return "view form for creating a post...";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(){

        return "Creating new post...";
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        //delete post
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {
        Post postToEdit = postDao.getOne(id);
        model.addAttribute("post", postToEdit);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id, @RequestParam String title, @RequestParam String body) {
        Post p = postDao.getOne(id);
        p.setTitle(title);
        p.setBody(body);
        postDao.save(p);
        return "redirect:/posts";
    }

}
