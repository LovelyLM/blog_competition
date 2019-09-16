package com.leiming.blog.service;

import com.leiming.blog.domain.Message;
import com.leiming.blog.dto.PageBean;

import java.util.List;

public interface MessageService {
    void save(Message message);
    List<Message> test();
    PageBean getMessagePageBean(Integer currentPage);
}
