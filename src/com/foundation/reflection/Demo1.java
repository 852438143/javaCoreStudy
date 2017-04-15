package com.foundation.reflection;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by 85243 on 2017/3/7.
 */
public class Demo1 {
    public static void main(String[] args) {
        User user = new User();
        User user2 = new User("User2aaaa",new Date());
        System.out.println(User.class);
        System.out.println(user.getClass());
        String userClassName = user.getClass().getName();
        try {
            Class clazz = Class.forName(userClassName);
            Field field =  clazz.getDeclaredField("name");
            //获取另一个对象的该字段值
            System.out.println(field.get(user2));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}


class User{
    String name;
    Date date ;

    public User() {
    }

    public User(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }
    public boolean equals(User other){
        //这里直接访问了另一个User类对象的私有域
        return name.equals(other.name);
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}

