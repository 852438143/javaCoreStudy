package com.designPatterns.adapter.interfaceAdaptor;

/**
 * 抽象类:用来实现接口的所有方法。
 * Created by 85243 on 2017/3/23.
 */
public abstract class Wrapper implements Sourceable{
    @Override
    public void method1() {
        //这里已经算实现了Sourceable方法,虽然没有写任何东西,但是{}说明了这个方法已经定义了
    }

    @Override
    public void method2() {
    }
}
