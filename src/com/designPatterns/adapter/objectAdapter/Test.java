package com.designPatterns.adapter.objectAdapter;

/**
 * 对象的适配器模式:
 * 当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Wrapper类，持有原类的一个实例，在Wrapper类的方法中，调用实例的方法就行。
 * Wrapper中通过拥有Source的实例,来解决接口不匹配问题
 * Created by 85243 on 2017/3/23.
 */
public class Test {
    public static void main(String[] args) {
        Wrapper wrapper = new Wrapper();
        wrapper.method1();
        wrapper.method2();
    }
}
