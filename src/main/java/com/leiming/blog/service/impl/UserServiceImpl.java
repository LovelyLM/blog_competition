package com.leiming.blog.service.impl;

import com.leiming.blog.domain.User;
import com.leiming.blog.repository.UserRepository;
import com.leiming.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    @Transactional
    public void modifyUsername(String username) {
        userRepository.modifyUsername(username);
    }

    @Override
    public User getOwner() {
        return userRepository.findById(1L).get();
    }

    @Override
    @Transactional
    public void modifyPassword(String password) {
        userRepository.modifyPassword(password);
    }

    @Override
    @Transactional
    public void modifyPersonalSign(String personalSign) {
        userRepository.modifyPersonalSign(personalSign);

    }

    @Override
    @Transactional
    public void modifyHead(String head) {
        userRepository.modifyHead(head);
    }

    @Override
    @Transactional
    public void modifyImage(String image) {
        userRepository.modifyImage(image);

    }
}
