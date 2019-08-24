package com.bbs.entity;

import javax.persistence.*;

/**
 * Created by valar on 2019/1/5.
 */
import lombok.*;
//自动生成get() 和 set()
@Getter
@Setter
//自动重写方法
@ToString
@EqualsAndHashCode
//自动创建构造方法
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;
    private String username;
    private String userpw;
    private String useremail;
    private String useraddress;
    private int userphone;
    private int userage;
    private String usersex;
    private String usertitle;
    private String userlink;
    private int userSee;
}
