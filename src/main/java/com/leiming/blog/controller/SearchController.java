package com.leiming.blog.controller;

import com.leiming.blog.domain.Blog;
import com.leiming.blog.domain.Catalog;
import com.leiming.blog.service.BlogService;
import com.leiming.blog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CatalogService catalogService;
    @RequestMapping(value = "/search")
    public ModelAndView search(String keyWord, Model model){
        if (keyWord ==null || keyWord.length() == 0||keyWord==""){
            System.out.println(keyWord);
            model.addAttribute("msg","非法参数!");
            return new ModelAndView("search_error.html","searchModel",model);

        }
        List<Blog> blogList =  blogService.searchBlog(keyWord);
        model.addAttribute("blogList",blogList);
        model.addAttribute("keyWord",keyWord);
        model.addAttribute("blogListSize",blogList.size());
        return new ModelAndView("search.html","searchModel",model);
    }
    @RequestMapping("/searchCatalog")
    public ModelAndView searchCatalog(String catalogId,Model model){
        Catalog cataLog =  catalogService.findAllByCatalogId(Long.valueOf(catalogId));

        model.addAttribute("blogList",cataLog.getBlogs());
        model.addAttribute("cataLog",cataLog.getCatalog());
        model.addAttribute("blogSize",cataLog.getBlogs().size());
        return new ModelAndView("search-catalog","catalogModel",model);

    }
}
