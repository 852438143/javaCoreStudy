package com.designPatterns.decorator;

/**
 * Created by 85243 on 2017/3/23.
 */
public class Decorator implements Sourceable{


    private Sourceable source;

    public Decorator(Sourceable source) {
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("老子要装饰下面这个傻逼,");
        source.method();
        System.out.println("突然感觉所有的设计模式都特么差不多,区别不大,这特么就日狗了");
    }
}
