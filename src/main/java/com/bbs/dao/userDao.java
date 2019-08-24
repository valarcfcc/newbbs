package com.bbs.dao;

import com.bbs.entity.admin;
import com.bbs.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by valar on 2019/1/5.
 */
@Repository
public interface userDao extends JpaRepository<user,Integer> {
    @Query("select s from user s where s.username=?1 and s.userpw=?2")
    user findByUserNameAndPw(String name, String pw);

}
