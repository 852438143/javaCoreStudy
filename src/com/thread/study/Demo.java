package com.thread.study;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过多线程实现同时给多个人发送消息
 * Created by 85243 on 2017/2/20.
 */
public class Demo {
    public static void main(String[] args) {
        List<User> listUser = new ArrayList<User>();
        for (int i = 0; i <30 ; i++) {
            listUser.add(new User("id:"+i,"name:"+i));
        }
        List<List<User>> afterlist = Demo.divideUser(listUser,6);
        UserThread userThread ;
        for (int i = 0; i < afterlist.size() ; i++) {
            userThread = new UserThread(afterlist.get(i));
            new Thread(userThread).start();
        }
    }
    public static <E> List<List<E>> divideUser(List<E> listUser,int size){
        List<List<E>> afterDivideUser = new ArrayList< List<E>>();
        int userSize = listUser.size();
        int threadNum = (userSize+size-1)/size;//相当于分页操作，
        for (int i = 0; i <threadNum ; i++) {
            List<E> subList = new ArrayList<E>();
            for(int j = 0;j < size;j++){
                subList.add(listUser.get(i*size+j));
            }
            afterDivideUser.add(subList);
        }
        return afterDivideUser;
    }
}
class UserThread implements Runnable{
    private List<User> list;

    public UserThread(List<User> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < list.size() ; i++) {
            System.out.println(Thread.currentThread().getId()+"  "+list.get(i).getId()+"     "+list.get(i).getName());
            
        }
    }
}
class User{
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

