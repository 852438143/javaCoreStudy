package com.designPatterns.singleton;

/**
 *饿汉模式:全局的单例实例在类装载时构建,是线程安全的
 * Created by 85243 on 2017/3/22.
 */
public class SingletonDemo1 {
    private final static SingletonDemo1 singleton = new SingletonDemo1();
//    运用私有的构造方法,防止该类在别处被实例化
    private SingletonDemo1() {
        System.out.println("我是在加载类的时候就初始化了");
    }

    public static SingletonDemo1 getInstance(){
        return singleton;
    }
}
