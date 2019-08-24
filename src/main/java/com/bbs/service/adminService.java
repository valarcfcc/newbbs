package com.bbs.service;

import com.bbs.dao.adminDao;
import com.bbs.entity.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by valar on 2019/1/5.
 */
@Service
public class adminService {
    @Autowired
    private adminDao adminDao;
    public boolean login(String username, String password){
        admin admin = adminDao.findByAdminNameAndPw(username, password);
        if(null == admin){
            return false;
        }else {
            return true;
        }
    }
}
