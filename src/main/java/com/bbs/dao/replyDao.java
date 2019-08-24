package com.bbs.dao;

import com.bbs.entity.reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by valar on 2019/1/5.
 */
@Repository
public interface replyDao extends CrudRepository<reply,Integer> {

    @Query("select s from reply s where s.titId=?1")
    List<reply> findByTitId(Integer id);
}
