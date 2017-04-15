package com.designPatterns.adapter.interfaceAdaptor;

/**
 * Created by 85243 on 2017/3/23.
 */
public class SubSourceable extends Wrapper{
    @Override
    public void method1() {
        System.out.println("我是子接口,我只实现了Sourceable里面的一个方法yy");
    }
}
