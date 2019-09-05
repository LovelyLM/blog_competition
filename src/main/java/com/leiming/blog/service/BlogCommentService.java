package com.leiming.blog.service;

import com.leiming.blog.domain.BlogComment;
import com.leiming.blog.dto.PageBean;

public interface BlogCommentService{
    void save(BlogComment blogComment);

    PageBean getMessagePageBean(Long blogId, Integer currentPage);
}
