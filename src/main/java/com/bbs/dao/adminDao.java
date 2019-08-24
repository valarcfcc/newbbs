package com.bbs.dao;

import com.bbs.entity.admin;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by valar on 2019/1/5.
 */
@Repository
public interface adminDao extends CrudRepository<admin,Integer> {
    @Query("select s from admin s where s.name=?1 and s.pw=?2")
    admin findByAdminNameAndPw(String name,String pw);
}
