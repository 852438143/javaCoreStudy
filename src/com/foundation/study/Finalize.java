package com.foundation.study;

/**
 * finalize方法,它在对象被注销前执行,可以用来查看对象的某种状态,判断对象是否该被注销
 * 这个程序不知道为什么没有执行finalize
 * Created by 85243 on 2017/4/5.
 */
public class Finalize {
    public static void main(String[] args) {
        Book b1 = new Book("b1");
        b1.setStatus(true);
        Book b2 = new Book("b2");
        //强制回收
        System.gc();
    }
}

/**
 * 如果Book对象的status 为false就在注销的时候显示错误信息
 */
class Book{
    boolean status = false;
    String name ;
    Book(){

    }

    Book(String name ){
        this.name = name ;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    protected void finalize() throws Throwable {
        if(!status) System.out.println("该对象状态为false,不可以被注销"+this.name);
//        super.finalize();
    }
}
