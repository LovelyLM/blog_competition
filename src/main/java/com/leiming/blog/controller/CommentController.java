package com.leiming.blog.controller;

import com.leiming.blog.domain.BlogComment;
import com.leiming.blog.domain.Message;
import com.leiming.blog.domain.Visitor;
import com.leiming.blog.dto.PageBean;
import com.leiming.blog.service.BlogCommentService;
import com.leiming.blog.service.BlogService;
import com.leiming.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CommentController {
    @Autowired
    private BlogCommentService blogCommentService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private BlogService blogService;
    @RequestMapping("/saveBlogComment")
    @ResponseBody
    public String saveBlogComment(BlogComment blogComment,HttpServletRequest servletRequest,String blogId){
        if (blogComment.getContent()==""||servletRequest.getSession().getAttribute("visitor")==null){
            return "no";
        }else {
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String time = simpleDateFormat.format(date);
            blogComment.setCreatTime(time);
            blogComment.setBlog(blogService.findAllById(Long.valueOf(blogId)));
            blogService.updateComment(Long.valueOf(blogId));
            blogComment.setVisitor((Visitor) servletRequest.getSession().getAttribute("visitor"));
            blogCommentService.save(blogComment);
            return "ok";
        }

    }
    @RequestMapping("/saveMessage")
    @ResponseBody
    public String saveComment(Message message, HttpServletRequest servletRequest){
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = simpleDateFormat.format(date);
        message.setCreatTime(time);
        if (servletRequest.getSession().getAttribute("visitor")==null){
            servletRequest.getSession().setAttribute("visitor",null);
            return "0";
        }else if (message.getContent()==""){
            servletRequest.getSession().setAttribute("visitor",null);
            return "1";
        } else {
            System.out.println(servletRequest.getSession().getAttribute("visitor"));
            message.setVisitor((Visitor) servletRequest.getSession().getAttribute("visitor"));
            messageService.save(message);
            servletRequest.getSession().setAttribute("visitor",null);
            return "ok";
        }
    }
    @RequestMapping("/findAllMessage")
    public ModelAndView findAllMessage(Integer currentPage, Model model){
        PageBean pageBean = messageService.getMessagePageBean(currentPage);
        model.addAttribute("messagePageBean",pageBean);
        return new ModelAndView("gustbook.html","messageModel",model);
    }
}
