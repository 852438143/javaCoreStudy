package com.designPatterns.adapter.classAdapter;

/**
 * Created by 85243 on 2017/3/23.
 */
public class Adaptor extends Source implements Targetable{


    @Override
    public void method2() {
        System.out.println("I'm implement Targetable interface");
    }
}
