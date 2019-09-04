package com.leiming.blog.controller;

import com.leiming.blog.domain.Message;
import com.leiming.blog.domain.Visitor;
import com.leiming.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CommentController {
    @Autowired
    private MessageService messageService;
    @RequestMapping("/saveMessage")
    @ResponseBody
    public String saveComment(Message message, HttpServletRequest servletRequest){
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = simpleDateFormat.format(date);
        message.setCreatTime(time);
        if (servletRequest.getSession().getAttribute("visitor")==null){
            return "留言失败，请检查qq是否填写正确！";
        }else if (message.getContent()==""){
            return "请输入留言！";
        } else {
            System.out.println(servletRequest.getSession().getAttribute("visitor"));
            message.setVisitor((Visitor) servletRequest.getSession().getAttribute("visitor"));
            messageService.save(message);
            return "留言成功！";
        }
    }
}
