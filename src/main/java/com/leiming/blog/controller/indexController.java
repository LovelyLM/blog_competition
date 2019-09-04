package com.leiming.blog.controller;

import com.leiming.blog.domain.Blog;
import com.leiming.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class indexController {
    @Autowired
    private BlogService blogService;
    @RequestMapping("/archives")
    @ResponseBody
    public ModelAndView archives(Model model){
        List<Blog> blogList =  blogService.findAllBlogByCreateTime();
        //时间线
        List<String> blogTimeLine =  blogService.findAllBlogTimeLine();
        List<String> strings = preTimeLine(blogTimeLine);
        System.out.println(strings);
        strings = removeDuplicate(preTimeLine(strings));
        System.out.println(strings);
        perArchives(blogList);
        model.addAttribute("blogList",blogList);
        model.addAttribute("blogTimeLine",strings);
        return new ModelAndView("archives.html","archivesModel",model);
    }
    private void perArchives(List<Blog> blogList){
        for (Blog blog: blogList) {
            blog.setCreateTime(blog.getCreateTime().substring(0,10));
        }
    }
    private List<String> preTimeLine(List<String> TimeLine){
        List<String> target = new ArrayList<>();
        for (String s: TimeLine) {
            s = s.substring(0,7);
            target.add(s);
        }
        return target;
    }
    private List<String> removeDuplicate(List<String> list)   {
        HashSet h  =   new  HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }
}
