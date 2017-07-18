package com.lang;

/**
 * A的子类,C的父类
 * Created by yangliwei on 2017/7/17.
 */
public class B extends A{

    private int b;

    private String bname;

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
