package com.leiming.blog.repository;

import com.leiming.blog.domain.BlogComment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlogCommentRepository extends CrudRepository<BlogComment,Long> {
    @Query(value = "select count(*) from blog_comment where blog_id = ?1",nativeQuery = true)
    Integer findAllBlogCommentNum(Long blogId);
    @Query(value = "select * from blog_comment where blog_id = ?1 ORDER BY creat_time DESC LIMIT ?2,?3",nativeQuery = true)
    List<BlogComment> findBlogCommentList(Long blogId, Integer start, Integer pageSize);
}
