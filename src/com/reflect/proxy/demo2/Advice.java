package com.reflect.proxy.demo2;

import java.lang.reflect.Method;

/**
 * Created by 85243 on 2017/4/13.
 */
public interface Advice {
    public void beforeMethod(Method method ,Object[] objects);
    public void afterMethod(Method method,Object[] objects);
}
