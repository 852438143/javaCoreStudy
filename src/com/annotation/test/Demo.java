package com.annotation.test;

import com.annotation.AnnotationDemo1;

/**
 * Created by 85243 on 2017/4/9.
 */
public class Demo {
    @AnnotationDemo1(name = "aaaaa")
    public String user ;

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String
    toString() {
        return "Demo{" +
                "user='" + user + '\'' +
                '}';
    }
}
