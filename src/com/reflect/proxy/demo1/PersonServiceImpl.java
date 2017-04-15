package com.reflect.proxy.demo1;

/**
 * Created by 85243 on 2017/4/9.
 */
public class PersonServiceImpl implements PersonService {
    private String name;

    public PersonServiceImpl() {
    }

    public PersonServiceImpl(String name) {

        this.name = name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
        System.out.println("使用了PersonServiceImpl 中的setName方法 name : " + name);
    }

    @Override
    public String getName() {
        System.out.println("使用了PersonServiceImpl 中的getName方法 name : " + name);
        return name;
    }


    @Override
    public void output() {
        System.out.println("使用了PersonServiceImpl 中的output 方法name : " + name);
    }
}
