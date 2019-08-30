package com.leiming.blog.controller;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;

import com.leiming.blog.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class UploadController {
    @Autowired
    private UserService userService;
    @ResponseBody
    @RequestMapping("/saveImage")
    public String saveImage(@RequestParam(value = "file") MultipartFile file) throws FileNotFoundException {
        String filename = file.getOriginalFilename();
        System.out.println(filename);
        //后缀获取
        String sname = filename.substring(filename.lastIndexOf("."));
        //获取当前时间
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String timeStamp=simpleDateFormat.format(new Date());
        //文件以“当前时间”+后缀形式存在，避免重复
        filename = timeStamp+sname;
        userService.modifyImage(filename);
        System.out.println("新的原始文件:"+filename);
        String path = ResourceUtils.getURL("classpath:").getPath()+"static/upload/ico_original";
        File dest = null;
        try {
            dest = new File(URLDecoder.decode(path+"/"+filename,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(dest.getParentFile());
        if (!dest.exists()){
            dest.mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }
    @ResponseBody
    @RequestMapping("/saveMoodImage")
    public String saveMoodImage(@RequestParam(value = "file") MultipartFile file, HttpServletRequest servletRequest) throws FileNotFoundException {
        String filename = file.getOriginalFilename();

        //后缀获取
        String sname = filename.substring(filename.lastIndexOf("."));

        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String timeStamp=simpleDateFormat.format(new Date());

        filename = timeStamp+sname;
        servletRequest.getSession().setAttribute("mood",filename);
        System.out.println("新的原始文件:"+filename);
        String path = ResourceUtils.getURL("classpath:").getPath()+"static/upload/mood";
        File dest = null;
        try {
            dest = new File(URLDecoder.decode(path+"/"+filename,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(dest.getParentFile());
        if (!dest.exists()){
            dest.mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }
    @ResponseBody
    @RequestMapping("/saveCoverImage")
    public String saveCoverImage(@RequestParam(value = "file") MultipartFile file, HttpServletRequest servletRequest) throws FileNotFoundException {
        String filename = file.getOriginalFilename();

        //后缀获取
        String sname = filename.substring(filename.lastIndexOf("."));

        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String timeStamp=simpleDateFormat.format(new Date());

        filename = timeStamp+sname;
        servletRequest.getSession().setAttribute("cover",filename);
        System.out.println("新的原始文件:"+filename);
        String path = ResourceUtils.getURL("classpath:").getPath()+"static/upload/cover";
        File dest = null;
        try {
            dest = new File(URLDecoder.decode(path+"/"+filename,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(dest.getParentFile());
        if (!dest.exists()){
            dest.mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }



}
