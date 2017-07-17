package com.foundation.method;

import java.util.Date;

/**
 * Created by 85243 on 2017/5/1.
 */
public class MethodOverLoad {
    public MethodOverLoad() {
    }

    public  MethodOverLoad(Date date){
        System.out.println("I'm a func Date");
    }

    public MethodOverLoad(String a){
        //貌似是通过这个Date判断下一个执行的构造方法的类型,如果换成String就会出现环,编译期报错
//        this(a!=null?new String():null);
        this(a!=null?new Date(): null);
        System.out.println("I'm a func String");
    }


    public static void main(String[] args) {
        //前两步是为了通过编译
        String a = "";
        a = null;
        MethodOverLoad method = new MethodOverLoad(a);

    }
}
