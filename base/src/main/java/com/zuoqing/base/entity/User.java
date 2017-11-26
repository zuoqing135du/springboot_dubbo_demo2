package com.zuoqing.base.entity;

import java.io.Serializable;

/**
 * Created by zuoqing on 2017/11/24.
 */
public class User implements Serializable{
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
