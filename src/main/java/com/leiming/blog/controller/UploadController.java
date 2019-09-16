package com.leiming.blog.controller;

import com.leiming.blog.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
        //后缀获取
        String sname = filename.substring(filename.lastIndexOf("."));
        //获取当前时间
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String timeStamp=simpleDateFormat.format(new Date());
        //文件以“当前时间”+后缀形式存在，避免重复
        filename = timeStamp+sname;
        userService.modifyImage(filename);
        System.out.println("新的原始文件:"+filename);
//        String path = "src/main/resources/static/upload/ico_original";
//        File file2 = new File(path);
//        try {
//            //构建真实的文件路径
//            File newFile = new File(file2.getAbsolutePath() + File.separator + filename);
//            System.out.println(newFile);
//            //转存文件到指定路径，如果文件名重复的话，将会覆盖掉之前的文件,这里是把文件上传到 “绝对路径”
//            file.transferTo(newFile);
//
//            return filename;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        String path = ResourceUtils.getURL("classpath:").getPath()+"static"+File.separator+"upload"+File.separator+"ico_original";
        System.out.println(path);
        File dest = null;
        try {
            dest = new File(URLDecoder.decode(path+File.separator+filename,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (!dest.exists()){
            dest.mkdirs();
        }
        System.out.println(dest);
        try {
            file.transferTo(dest);
            return filename;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "failed";
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
        System.out.println("hhhhhhhhhhhhhhhhhhhh-------:"+path);
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
