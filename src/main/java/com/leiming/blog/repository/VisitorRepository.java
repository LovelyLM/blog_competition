package com.leiming.blog.repository;

import com.leiming.blog.domain.Visitor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VisitorRepository extends CrudRepository<Visitor,Long> {
    @Query(value = "select * from visitor where name = ?1",nativeQuery = true)
    Visitor findByName(String name);
    @Query(value = "select * from visitor where qq = ?1",nativeQuery = true)
    Visitor findByQq(String qq);
}
