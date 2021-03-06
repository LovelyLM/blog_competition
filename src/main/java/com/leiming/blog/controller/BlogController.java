package com.leiming.blog.controller;

import com.leiming.blog.domain.Blog;
import com.leiming.blog.domain.BlogComment;
import com.leiming.blog.domain.Catalog;
import com.leiming.blog.domain.User;
import com.leiming.blog.dto.PageBean;
import com.leiming.blog.service.BlogCommentService;
import com.leiming.blog.service.BlogService;
import com.leiming.blog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CatalogService catalogsService;
    @Autowired
    private BlogCommentService blogCommentService;
    @RequestMapping("/saveBlog")
    @ResponseBody
    public String saveMood(Blog blog, HttpServletRequest servletRequest, String catalogString){

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String createTime = format.format(date);
        blog.setCreateTime(createTime);
        blog.setCatalogs(new HashSet<Catalog>());
        if (servletRequest.getSession().getAttribute("cover")!=null){
            blog.setCover((String) servletRequest.getSession().getAttribute("cover"));
        }else {
            blog.setCover("default.jpeg");
        }
        blog.setCommentNumber(0L);
        blog.setViewNumber(0L);
        String[] split = catalogString.split(";");
        for (String s:split) {
            Catalog catalog =new Catalog(null,s,new HashSet<Blog>());
            Catalog temp = catalogsService.findCatalogByCatalog(s);
            if (temp==null){
                catalogsService.saveCatalog(catalog);
            }else {
                catalog = temp;
            }
            blog.getCatalogs().add(catalog);
        }
        blogService.save(blog);
        servletRequest.getSession().setAttribute("cover","default.jpeg");
        return "redirect:/blog";
    }
    @RequestMapping("blog")
    @ResponseBody
    public ModelAndView findAllBlog(Model model){
        List<Blog> blogList = blogService.findAllBlogLimit7();
        List<Catalog> catalogList= catalogsService.findAllCatalog();
        model.addAttribute("blogList",blogList);
        model.addAttribute("catalogList",catalogList);
        return new ModelAndView("blog.html","blogModel",model);
    }
    @RequestMapping("blogDetail")
    @ResponseBody
    public ModelAndView blogDetail(Model model,String id,Integer currentPage){
        blogService.updateReads(Long.valueOf(id));
        Blog blog = blogService.findAllById(Long.valueOf(id));
        PageBean blogCommentPageBean = blogCommentService.getMessagePageBean(Long.valueOf(id),currentPage);
        model.addAttribute("blogCommentPageBean",blogCommentPageBean);
        model.addAttribute("blog",blog);
        return new ModelAndView("detail.html","blogModel",model);
    }
    @RequestMapping(value = "/delBlog",method = RequestMethod.POST )
    @ResponseBody
    public String delBlog(String blogId){
        if (blogId!=null&&blogId!=""){
            blogService.delBlog(blogId);
            return "ok";
        }
        return "no";
    }
}
