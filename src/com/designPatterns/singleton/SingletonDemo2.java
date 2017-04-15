package com.designPatterns.singleton;

/**
 *懒汉方式(lazy initialization):指全局的单例实例在第一次使用的时候被构建,多线程的时候不安全,接下来会有demo对懒加载线程安全性的分析
 * Created by 85243 on 2017/3/22.
 */
public class SingletonDemo2 {
    private static SingletonDemo2 singletonDemo2 =null;

    private SingletonDemo2() {
        System.out.println("我是在实例化的时候初始化了");
    }


    public static SingletonDemo2 getInstance(){
        if(singletonDemo2==null){
            singletonDemo2 = new SingletonDemo2();
        }
        return singletonDemo2;
    }
}
