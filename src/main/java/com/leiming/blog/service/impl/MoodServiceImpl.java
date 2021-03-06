package com.leiming.blog.service.impl;

import com.leiming.blog.domain.Mood;
import com.leiming.blog.repository.MoodRepository;
import com.leiming.blog.repository.UserRepository;
import com.leiming.blog.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MoodServiceImpl implements MoodService {
    @Autowired
    MoodRepository moodRepository;
    @Override
    public void save(Mood mood) {
        moodRepository.save(mood);
    }

    @Override
    public List<Mood> findAllMood() {
        List<Mood> moods = moodRepository.findAllMoodByTime();
        return moods;
    }

    @Override
    public void deleteMoodById(long id) {
        moodRepository.deleteById(id);
    }

    @Override
    public List<Mood> findAllMoodLimit7() {
        return moodRepository.findAllMoodLimit7();
    }

}
