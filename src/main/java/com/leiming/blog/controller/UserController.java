package com.leiming.blog.controller;

import com.leiming.blog.domain.User;
import com.leiming.blog.enumeration.ModifyType;
import com.leiming.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public void modifyUser(ModifyType modifyType,String modifyInfo){
        switch (modifyType){
            case HEAD:
                userService.modifyHead(modifyInfo);
                break;
            case PASSWORD:
                userService.modifyPassword(modifyInfo);
                break;
            case USERNAME:
                userService.modifyUsername(modifyInfo);
                break;
            case PERSONAL_SIGN:
                userService.modifyPersonalSign(modifyInfo);
                break;
                default:
                    break;
        }
    }
    @RequestMapping("/modifyUsername")
    public String modifyUsername(String username){
        modifyUser(ModifyType.USERNAME,username);
        return "user.html";
    }
    @RequestMapping("/modifyPassword")
    public String modifyPassword(String password){
        modifyUser(ModifyType.PASSWORD,password);
        return "user.html";
    }
    @RequestMapping("/modifyPersonalSign")
    public String modifyPersonalSign(String personalSign){
        modifyUser(ModifyType.PERSONAL_SIGN,personalSign);
        return "user.html";
    }
    @RequestMapping("/getOwner")
    public String getOwner(){
        return "user.html";
    }
    @RequestMapping("/uploadHeadImage")
    public String uploadHeadImage(String base64) throws IOException {
        System.out.println(base64);
        String path = ResourceUtils.getURL("classpath:").getPath()+"static/upload/ico";
        path = java.net.URLDecoder.decode(path, "utf-8");
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        //获取当前时间
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String timeStamp=simpleDateFormat.format(new Date());
        String base64Data =  base64.split(",")[1];
        /**
         * 2.解码成字节数组
         */
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(base64Data);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path+"/"+timeStamp+".jpg");
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        modifyUser(ModifyType.HEAD,timeStamp+".jpg");


        return "redirect:/user";
    }

}
