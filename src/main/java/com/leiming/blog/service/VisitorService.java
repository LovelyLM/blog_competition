package com.leiming.blog.service;

import com.leiming.blog.domain.Visitor;

public interface VisitorService {
    Visitor findByQq(String qq);

    Visitor findByName(String name);

    Visitor save(Visitor visitor);
}
