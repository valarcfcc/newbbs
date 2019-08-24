package com.bbs.service;

import com.bbs.dao.replyDao;

import com.bbs.entity.reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by valar on 2019/1/5.
 */
@Service
public class replyService {
    @Autowired
    private replyDao replyDao;
    private reply reply;
    public List<reply> getReply(Integer id){
        return replyDao.findByTitId(id);
    }
    public boolean doReply(int titId,String replyText,int userId,String username){
        reply reply = new reply();
        java.text.SimpleDateFormat simpleDateFormat = new  java.text.SimpleDateFormat("yy-MM-dd HH:mm:ss");
        java.util.Date currentTime = new  java.util.Date();
        String time =  simpleDateFormat.format(currentTime).toString();
        reply.setReplyText(replyText);
        reply.setReplyTime(time);
        reply.setTitId(titId);
        reply.setUserId(userId);
        reply.setUsername(username);
        reply isSave = replyDao.save(reply);
        if(isSave == null)
            return false;
        else
        {
            System.out.println(reply.getTitId());
            return true;
        }
    }
}
