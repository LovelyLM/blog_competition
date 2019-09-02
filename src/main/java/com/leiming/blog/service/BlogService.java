package com.leiming.blog.service;

import com.leiming.blog.domain.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BlogService {
    void save(Blog blog);

    List<Blog> findAllBlog();
}
