package com.reflect.proxy.demo1;

import org.junit.Test;

/**
 * 这里主要运用代理机制实现了aop的技术,目前对代理不了解,等了解了在来深入
 * Created by 85243 on 2017/4/9.
 */
public class Demo {
    @Test
    public void test01(){
        ProxyFactory pf = new ProxyFactory();
        PersonService ps = (PersonService) pf.creatProxyInstance(new PersonServiceImpl("shagou"));
//        这里最好不要使用getName方法,因为判断是否为空的时候已经调用了getName方法,影响测试结果
//        ps.getName();
        ps.output();
    }
}
