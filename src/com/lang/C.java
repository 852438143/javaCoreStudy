package com.lang;

/**
 * B的子类
 * Created by yangliwei on 2017/7/17.
 */
public class C extends B{
    private int c;

    private String cname;

    private D d;


    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public D getD() {
        return d;
    }

    public void setD(D d) {
        this.d = d;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
