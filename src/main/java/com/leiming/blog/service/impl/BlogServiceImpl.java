package com.leiming.blog.service.impl;

import com.leiming.blog.domain.Blog;
import com.leiming.blog.repository.BlogRepository;
import com.leiming.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Blog findAllById(Long id) {
        Optional<Blog> blog = blogRepository.findById(id);
        return blog.get();
    }

    @Override
    public List<Blog> findAllBlogByCreateTime() {
        return blogRepository.findAllByCreateTime();
    }

    @Override
    public List<String> findAllBlogTimeLine() {
        return blogRepository.findBlogTimeLine();
    }

    @Override
    public void delBlog(String blogId) {
        blogRepository.deleteById(Long.valueOf(blogId));
    }

    @Override
    public List<Blog> searchBlog(String keyWord) {
        return blogRepository.searchBlog(keyWord);
    }

    @Override
    public void updateReads(Long blogId) {
        blogRepository.updateReads(blogId);
    }

    @Override
    public void updateComment(Long blogId) {
        blogRepository.updateComment(blogId);
    }
}
