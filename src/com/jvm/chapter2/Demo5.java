package com.jvm.chapter2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *方法区用于存放Class的相关信息
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 *
 * 这里使用大量的类区填满方法区,知道溢出,使用CGLib直接操作字节码
 */
public class Demo5 {
    public static void main(String[] args) {
        while(true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o,objects);
                }
            });
            enhancer.create();
        }
    }
    static class OOMObject{
        public OOMObject() {
        }
    }
}
