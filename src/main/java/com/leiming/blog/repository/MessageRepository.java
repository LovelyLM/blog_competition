package com.leiming.blog.repository;

import com.leiming.blog.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message,Long> {
}
