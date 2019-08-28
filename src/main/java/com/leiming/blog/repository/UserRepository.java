package com.leiming.blog.repository;

import com.leiming.blog.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    @Query(value = "update user set username =?1 where id =1",nativeQuery = true)
    @Modifying
    void modifyUsername(String username);

    @Query(value = "update user set password =?1 where id =1",nativeQuery = true)
    @Modifying
    void modifyPassword(String password);

    @Query(value = "update user set personal_sign =?1 where id =1",nativeQuery = true)
    @Modifying
    void modifyPersonalSign(String personal_sign);
    @Query(value = "update user set image =?1 where id =1",nativeQuery = true)
    @Modifying
    void modifyHead(String head);
    @Query(value = "update user set image_original =?1 where id =1",nativeQuery = true)
    @Modifying
    void modifyImage(String image);
}
