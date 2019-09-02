package com.leiming.blog.service.impl;

import com.leiming.blog.domain.Blog;
import com.leiming.blog.repository.BlogRepository;
import com.leiming.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> findAllBlog() {
        Iterable<Blog> blogList = blogRepository.findAll();
        return (List<Blog>) blogList;
    }
}
