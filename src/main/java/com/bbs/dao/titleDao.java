package com.bbs.dao;

import com.bbs.entity.reply;
import com.bbs.entity.title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by valar on 2019/1/5.
 */
@Repository
public interface titleDao extends CrudRepository<title, Integer> {

    @Query("select s from title s where s.titId=?1")
    title findByTitId(Integer id);
}
