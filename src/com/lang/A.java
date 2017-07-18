package com.lang;

/**
 * 是b的父类，主要用来测试clone方法
 * Created by yangliwei on 2017/7/17.
 */
public class A implements Cloneable{

    private int a;
    private String aname;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
