package com.designPatterns.singleton;

/**
 * 单例模式，也叫单子模式，是一种常用的软件设计模式。在应用这个模式时，单例对象的类必须保证只有一个实例存在。
 * 许多时候整个系统只需要拥有一个的全局对象，这样有利于我们协调系统整体的行为。比如在某个服务器程序中，该服务
 * 器的配置信息存放在一个文件中，这些配置数据由一个单例对象统一读取，然后服务进程中的其他对象再通过这个单例对
 * 象获取这些配置信息。这种方式简化了在复杂环境下的配置管理。


 类什么时候加载
 类的加载是通过类加载器（Classloader）完成的，它既可以是饿汉式[eagerly load]（只要有其它类引用了它就加载）加载类，
 也可以是懒加载[lazy load]（等到类初始化发生的时候才加载）。不过我相信这跟不同的JVM实现有关，然而他又是受JLS保证的（当有静态初始化需求的时候才被加载）。

 类什么时候初始化
 加载完类后，类的初始化就会发生，意味着它会初始化所有类静态成员，以下情况一个类被初始化：
 1.实例通过使用new()关键字创建或者使用class.forName()反射，但它有可能导致ClassNotFoundException。
 2.类的静态方法被调用
 3.类的静态域被赋值
 4.静态域被访问，而且它不是常量
 5.在顶层类中执行assert语句
 * Created by 85243 on 2017/3/22.
 */
public class Test {
    public static void main(String[] args) {
        //不要关系下面的文字了,因为我也不清楚类加载和初始化,很奇怪的

        System.out.println("准备调用SingletonDemo1 观察它什么时候初始化呀！");
        SingletonDemo1.getInstance();
        System.out.println("感觉初始化的语句在实例化前面哦,所以是在类加载的时候初始化的,应该是在classload,这里面应该还和static有关系,等学完jvm在深入分析");
        System.out.println("准备调用SingletonDemo2 观察它什么时候初始化呀！");
        SingletonDemo2.getInstance();
        System.out.println("这个初始化语句在中间,所以它是在类实例化的时候调用的,延迟加载,");
    }
}
