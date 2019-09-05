package com.leiming.blog.repository;

import com.leiming.blog.domain.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message,Long> {
    @Query(value = "select count(*) from message",nativeQuery = true)
    Integer findAllMessageNum();
    @Query(value = "select * from message ORDER BY creat_time DESC LIMIT ?1,?2",nativeQuery = true)
    List<Message> findMessageList(Integer start, Integer pageSize);
}
