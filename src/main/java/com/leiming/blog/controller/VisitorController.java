package com.leiming.blog.controller;

import com.leiming.blog.domain.Visitor;
import com.leiming.blog.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class VisitorController {
    @Autowired
    private VisitorService visitorService;
    @RequestMapping("/saveVisitor")
    @ResponseBody
    public String saveVisitor(Visitor visitor, HttpServletRequest servletRequest){
        System.out.println(visitor+"--------");
        if (checkQQ(visitor.getQq())){
            if (visitor.getQq()==""||visitor.getName()==""){
                return "请检查qq与昵称是否输入正确";
            }
            Visitor byQq = visitorService.findByQq(visitor.getQq());

            if (byQq ==null){
                Visitor save = visitorService.save(visitor);
                servletRequest.getSession().setAttribute("visitor",save);
                return "自动注册成功，将以此qq留言！";
            }else if (byQq.getName().equals(visitor.getName())){
                servletRequest.getSession().setAttribute("visitor",byQq);
                return "将继续以此qq留言";

            } else {
                servletRequest.getSession().setAttribute("visitor",byQq);
                return "由于此qq已留过言，昵称无法更改！";
            }

        }else {
            return "qq不合法！";
        }

    }
    public static boolean checkQQ(String qq){
        boolean flag = true;
        //校验长度
        if(qq.length() >= 5 && qq.length() <=15){
            //0不开头
            if(!qq.startsWith("0")){
                //必须是数字
                char[] chs = qq.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    char c = chs[i];
                    if(!Character.isDigit(c)){
                        flag = false;
                        break;
                    }

                }
            }else{
                flag = false;
            }
        }else{
            flag = false;
        }

        return flag;
    }
}
