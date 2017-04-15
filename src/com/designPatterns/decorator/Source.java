package com.designPatterns.decorator;

/**
 * Created by 85243 on 2017/3/23.
 */
public class Source implements Sourceable{
    @Override
    public void method() {
        System.out.println("我特么被装饰了");
    }
}
