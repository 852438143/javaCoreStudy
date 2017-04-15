package com.reflect.proxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类,这里需要深入学习下
 * Created by 85243 on 2017/4/9.
 */
public class ProxyFactory implements InvocationHandler {
    private Object obj = new Object();//目标对象
    public Object creatProxyInstance(Object obj) {
        //三个参数分别使对象的类,对象的接口,和对象的代理类对象
        this.obj = obj;
//        返回的使代理对象
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);

    }

    //回调方法,从InvocationHandler里面继承的
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PersonServiceImpl ps = (PersonServiceImpl) this.obj;
        Object result = null;
        if (ps.getName() != null&&!ps.getName().equals("")) {
            System.out.println("调用了回调方法");
            result = method.invoke(obj, args);
        }
        return result;
    }
}
