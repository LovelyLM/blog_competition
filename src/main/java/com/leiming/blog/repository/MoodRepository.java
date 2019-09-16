package com.leiming.blog.repository;


import com.leiming.blog.domain.Mood;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MoodRepository extends CrudRepository<Mood,Long> {
    @Query(value = "select * from mood order by creat_time desc",nativeQuery = true)
    List<Mood> findAllMoodByTime();
    @Query(value = "SELECT * FROM mood ORDER BY creat_time DESC LIMIT 7 ",nativeQuery = true)
    List<Mood> findAllMoodLimit7();
}
