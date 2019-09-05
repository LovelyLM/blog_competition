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
import org.springframework.web.bind.annotation.ResponseBody;
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
    @ResponseBody
    public ModelAndView index(Model model){
        List<Blog> blogList = blogService.findAllBlog();
        List<Mood> moodList =moodService.findAllMood();
        model.addAttribute("moodList",moodList);
        model.addAttribute("blogList",blogList);
        return new ModelAndView("index.html","indexModel",model);
    }
    @RequestMapping("/gustbook")
    public String gustbook(){
        return "redirect:/findAllMessage";
    }
    @RequestMapping("/link")
    public String link(){
        return "link.html";
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
    @RequestMapping("/imageDetail")
    public String imageDetail(){
        return "image-detail.html";
    }
    @RequestMapping("/addImage")
    public String imageImage(){
        return "add-image.html";
    }
    @RequestMapping("/visitorLogin")
    public String visitorLogin(){
        return "login.html";
    }
}
