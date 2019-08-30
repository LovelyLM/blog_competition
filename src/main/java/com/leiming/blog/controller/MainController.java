package com.leiming.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String root(){
        return "redirect:/index";
    }
    @RequestMapping("/index")
    public String index(){
        return "index.html";
    }
    @RequestMapping("/mood")
    public String mood(){
        return "mood.html";
    }
    @RequestMapping("/gustbook")
    public String gustbook(){
        return "gustbook.html";
    }
    @RequestMapping("/link")
    public String link(){
        return "link.html";
    }
    @RequestMapping("/archives")
    public String archives(){
        return "archives.html";
    }
    @RequestMapping("/blog")
    public String blog(){
        return "blog.html";
    }
    @RequestMapping("/image")
    public String image(){
        return "image.html";
    }
    @RequestMapping("/user")
    public String user(){
        return "user.html";
    }
    @RequestMapping("/detail")
    public String detail(){
        return "detail.html";
    }
    @RequestMapping("/addBlog")
    public String addBlog(){
        return "add-blog.html";
    }
}
