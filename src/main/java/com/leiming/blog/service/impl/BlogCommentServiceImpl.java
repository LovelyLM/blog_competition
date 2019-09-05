package com.leiming.blog.service.impl;

import com.leiming.blog.domain.BlogComment;
import com.leiming.blog.dto.PageBean;
import com.leiming.blog.repository.BlogCommentRepository;
import com.leiming.blog.service.BlogCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogCommentServiceImpl implements BlogCommentService {
    @Autowired
    private BlogCommentRepository blogCommentRepository;
    @Override
    public void save(BlogComment blogComment) {
        blogCommentRepository.save(blogComment);
    }

    @Override
    public PageBean getMessagePageBean(Long id ,Integer currentPage) {
        Integer totalCount = blogCommentRepository.findAllBlogCommentNum(id);
        PageBean pageBean = new PageBean(currentPage,totalCount,5);
        List<BlogComment> blogCommentList = blogCommentRepository.findBlogCommentList(id,pageBean.getStart(),pageBean.getPageSize());
        pageBean.setList(blogCommentList);
        return pageBean;
    }
}
