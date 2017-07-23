package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by panting1 on 2017/7/22.
 */
@Entity
public class User {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    //必须要有无参构造方法 否则创建表会失败
    public User() {
    }

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer money;
}
