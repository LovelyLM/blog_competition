package com.leiming.blog.repository;

import com.leiming.blog.domain.Mood;
import org.springframework.data.repository.CrudRepository;

public interface MoodRepository extends CrudRepository<Mood,Long> {
}
