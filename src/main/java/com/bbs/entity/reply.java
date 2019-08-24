package com.bbs.entity;

import javax.persistence.*;
import java.sql.Date;

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
public class reply {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private int titId;
    @Column(columnDefinition = "varchar(64)")
    private String replyTime;
    @Column(columnDefinition = "text")
    private String replyText;
    private int userId;
    private String username;
}
