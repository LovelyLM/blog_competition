package com.leiming.blog.service;

import com.leiming.blog.domain.Mood;

import java.util.List;

public interface MoodService {
    void save(Mood mood);


    List<Mood> findAllMood();

    void deleteMoodById(long id);
}
