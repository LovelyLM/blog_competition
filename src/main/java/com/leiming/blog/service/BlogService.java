package com.leiming.blog.service;

import com.leiming.blog.domain.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BlogService {
    void save(Blog blog);

    List<Blog> findAllBlog();

    Blog findAllById(Long id);

    List<Blog> findAllBlogByCreateTime();

    List<String> findAllBlogTimeLine();

    void delBlog(String blogId);

    List<Blog> searchBlog(String keyWord);

    void updateReads(Long blogId);

    void updateComment(Long blogId);
}
