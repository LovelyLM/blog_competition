package com.leiming.blog.service.impl;

import com.leiming.blog.domain.Visitor;
import com.leiming.blog.repository.VisitorRepository;
import com.leiming.blog.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    private VisitorRepository visitorRepository;
    @Override
    public Visitor findByQq(String qq) {
        return visitorRepository.findByQq(qq);
    }

    @Override
    public Visitor findByName(String name) {
        return visitorRepository.findByName(name);
    }

    @Override
    public Visitor save(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

}
