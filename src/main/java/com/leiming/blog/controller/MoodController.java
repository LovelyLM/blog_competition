package com.leiming.blog.controller;

import com.leiming.blog.domain.Mood;
import com.leiming.blog.domain.User;
import com.leiming.blog.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MoodController {
    @Autowired
    private MoodService moodService;
    @RequestMapping("/findMood")
    public ModelAndView findMood(Model model){
        List<Mood> moodList =moodService.findAllMood();
        model.addAttribute("moodList",moodList);
        return new ModelAndView("/mood","moodModel",moodList);
    }
    @RequestMapping("/saveMood")
    public String saveMood(Mood mood, HttpServletRequest servletRequest){
        System.out.println(mood);
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String createTime = format.format(date);
        System.out.println(createTime);
        mood.setCreatTime(createTime);
        mood.setImage((String) servletRequest.getSession().getAttribute("mood"));
        User owner = (User) servletRequest.getAttribute("owner");
        mood.setUser(owner);
        moodService.save(mood);
        return "redirect:/findMood";
    }
    @RequestMapping("/deleteMood")
    @ResponseBody
    public String deleteMood(String id){
        System.out.println(id);

        moodService.deleteMoodById(Long.parseLong(id));
        return "ok";
    }
}
