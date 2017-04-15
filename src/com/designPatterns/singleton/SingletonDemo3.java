package com.designPatterns.singleton;

/**
 * 通过静态内部类实现单例,当getInstant被调用时,触发了内部类SingletonDemoHolder初始化,而这个类初始化的时候会初始化静态域,从而创建SingeltonDemo3实例
 * 这样实现的优势时延迟加载,并且只会在虚拟机装载类的时候初始化一次.
 * Created by 85243 on 2017/3/23.
 */
public class SingletonDemo3 {
    private  SingletonDemo3() {
    }
    public  static class SingletonDemoHolder{
        public static SingletonDemo3 singleton = new SingletonDemo3();
    }
    public static SingletonDemo3 getInstant(){
        return SingletonDemoHolder.singleton;
    }
}
