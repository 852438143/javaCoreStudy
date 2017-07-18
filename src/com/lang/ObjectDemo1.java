package com.lang;

import org.junit.Test;

/**
 * 用于测试java lang 包里面的类
 * Created by yangliwei on 2017/7/17.
 */
public class ObjectDemo1 {

    /**
     * 测试Object里面的clone方法
     */
    @Test
    public void test01() throws CloneNotSupportedException {

        D d = new D();
        d.setD(4);
        d.setDname("D");
        C c = new C();
        c.setC(3);
        c.setCname("C");
        c.setB(2);
        c.setBname("B");
        c.setA(1);
        c.setAname("A");
        c.setD(d);

        C cloneObject = (C) c.clone();
    }

    /**
     * 测试hashCode方法
     */
    @Test
    public void testHashCode() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Integer i = obj1.hashCode();
        Integer j = obj2.hashCode();

    }

    /**
     * getClass()
     * 返回该对象所表示的类
     */
    @Test
    public void testGetClass() {
        Number n = 1;
        Class<? extends Number> nClass = n.getClass();
        System.out.println(nClass.getName());
    }

    /**
     * 在对象在被回收前肯定会调用一次，但调用了对象不一定马上被回收，可以用来在判断对象是否还有用，如果有用可以把对象clone,
     * 想法：可以用在数据库的保存上面，当高并发时，可以把数据放在队列里面，当发生gc的时候观察是否要拯救这个对象
     * 不推荐使用
     */
    @Test
    public void testFinalize() {
        Integer i = new Integer(1);
        System.gc();
    }




}
