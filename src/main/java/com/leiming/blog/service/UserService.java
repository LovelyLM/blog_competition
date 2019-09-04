package com.leiming.blog.service;

import com.leiming.blog.domain.User;
import org.springframework.stereotype.Service;

public interface UserService {
    void modifyUsername(String username);

    User getOwner();

    void modifyPassword(String password);

    void modifyPersonalSign(String personalSign);

    void modifyHead(String head);

    void modifyImage(String Image);

    User findUserByUsername(String username);
}
