package com.leiming.blog.repository;

import com.leiming.blog.domain.Blog;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlogRepository extends CrudRepository<Blog,Long> {
    @Query(value = "select * from blog order by create_time desc",nativeQuery = true)
    @Modifying
    List<Blog> findAllByCreateTime();
    @Query(value = "select create_time from blog order by create_time desc",nativeQuery = true)
    @Modifying
    List<String> findBlogTimeLine();
}
