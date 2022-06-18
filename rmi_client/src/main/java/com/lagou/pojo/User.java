package com.lagou.pojo;

import java.io.Serializable;

/**
 * @author ADMIN
 * 流中传输 需要实现序列化接口
 * @date 2022/6/16 22:08
 */
public class User implements Serializable {
    private int age;

    private String name;

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
