package com.foundation;

/**
 * 查看对象初始化的过程
 * 当没有初始化对象的时候为null
 * 默认无参构造函数是不自动初始化的
 * Created by 85243 on 2017/4/5.
 */
public class Initialization {
    public static void main(String[] args) {
        String1 s1 = new String1();
        System.out.println(s1.str);
        String2 s2 = new String2();
        System.out.println("s2 is: "+s2.str);
        String3 s3 = new String3("aaa");
        System.out.println(s3.str);

    }
}

/**
 * 一个str未被初始化的类
 */
class String1{
    String str;
}

/**
 * 一个在定义时期就被初始化的类
 */
class String2{
    String str= new String();
}

/**
 * 一个在新建对象就初始化的str
 */
class String3{
    String str ;

    public String3(String str) {
        System.out.println("在新建对象的时候初始化");
        this.str = str;
    }

}
