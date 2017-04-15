package com.reflect.proxy.demo2;

import java.lang.reflect.Method;

/**
 * Created by 85243 on 2017/4/13.
 */
public class MyAdvice implements Advice{
    @Override
    public void beforeMethod(Method method, Object[] objects) {
        System.out.println("before方法被执行了,接下来执行: "+method.getName()+"  参数是: "+objects);
    }

    @Override
    public void afterMethod(Method method, Object[] objects) {
        System.out.println(method.getName()+"方法被执行了完了"+ "after方法被执行了");
    }
}
