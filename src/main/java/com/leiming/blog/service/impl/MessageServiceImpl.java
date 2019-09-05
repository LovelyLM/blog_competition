package com.leiming.blog.service.impl;

import com.leiming.blog.domain.Message;
import com.leiming.blog.dto.PageBean;
import com.leiming.blog.repository.MessageRepository;
import com.leiming.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Override
    public void save(Message message) {
        messageRepository.save(message);
    }

    @Override
    public PageBean getMessagePageBean(Integer currentPage) {
        Integer totalCount = messageRepository.findAllMessageNum();
        PageBean pageBean = new PageBean(currentPage,totalCount,5);
        List<Message> messageList = messageRepository.findMessageList(pageBean.getStart(),pageBean.getPageSize());
        pageBean.setList(messageList);
        return pageBean;
    }
}
