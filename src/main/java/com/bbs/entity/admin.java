package com.bbs.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String pw;
}
