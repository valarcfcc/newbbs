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
public class discuss {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int disId;
    private String disName;
    @Column(columnDefinition = "text")
    private String disText;
    private int userId;
    @Column(columnDefinition = "varchar(64)")
    private String disTime;
    private int disSee;
    private long disYes;
    private long disNo;
}
