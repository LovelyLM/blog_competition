package com.leiming.blog.service.impl;

import com.leiming.blog.domain.Message;
import com.leiming.blog.repository.MessageRepository;
import com.leiming.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Override
    public void save(Message message) {
        messageRepository.save(message);
    }
}
