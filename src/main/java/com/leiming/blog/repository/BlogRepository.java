package com.leiming.blog.repository;

import com.leiming.blog.domain.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<Blog,Long> {
}
