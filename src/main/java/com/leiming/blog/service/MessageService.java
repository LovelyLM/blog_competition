package com.leiming.blog.service;

import com.leiming.blog.domain.Message;
import com.leiming.blog.dto.PageBean;

public interface MessageService {
    void save(Message message);

    PageBean getMessagePageBean(Integer currentPage);
}
