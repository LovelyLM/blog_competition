package com.leiming.blog.repository;

import com.leiming.blog.domain.Blog;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BlogRepository extends CrudRepository<Blog,Long> {
    @Query(value = "select * from blog order by create_time desc",nativeQuery = true)
    @Modifying
    List<Blog> findAllByCreateTime();
    @Query(value = "select create_time from blog order by create_time desc",nativeQuery = true)
    @Modifying
    List<String> findBlogTimeLine();
    @Query(value = "select * from blog where content like %?1% or title like %?1% or little_title like %?1% order by create_time desc ",nativeQuery = true)
    List<Blog> searchBlog(String keyWord);
    @Query(value = "UPDATE blog SET view_number = view_number + 1 WHERE id = ?1",nativeQuery = true)
    @Modifying
    @Transactional
    void updateReads(Long blogId);
    @Query(value = "UPDATE blog SET comment_number = comment_number + 1 WHERE id = ?1",nativeQuery = true)
    @Modifying
    @Transactional
    void updateComment(Long blogId);
}
