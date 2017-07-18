package com.lang;

/**
 * Created by yangliwei on 2017/7/17.
 */
public class D {

    private int d;
    private  String dname;

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
