package com.codeup.julyspringblog.controllers;

import com.codeup.julyspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String getPosts(Model model){
        ArrayList<Post> postList = new ArrayList<>();
        postList.add(new Post(2, "Second Post", "blalalkjlkfd"));
        postList.add(new Post(3, "Third Post", "more text..."));

        model.addAttribute("posts", postList);

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

    @RequestMapping(path="/posts", method=RequestMethod.DELETE)
    @ResponseBody
    public String delete(){
        return "DELETE";
    }

}
