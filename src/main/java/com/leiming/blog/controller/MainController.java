package com.leiming.blog.controller;

import com.leiming.blog.domain.Blog;
import com.leiming.blog.domain.Catalog;
import com.leiming.blog.domain.Mood;
import com.leiming.blog.service.BlogService;
import com.leiming.blog.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private MoodService moodService;
    @RequestMapping("/")
    public String root(){
        return "redirect:/index";
    }
    @RequestMapping("/index")
    public ModelAndView index(Model model){
        List<Blog> blogList = blogService.findAllBlog();
        List<Mood> moodList =moodService.findAllMood();
        model.addAttribute("moodList",moodList);
        model.addAttribute("blogList",blogList);
        return new ModelAndView("/index","indexModel",model);
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
