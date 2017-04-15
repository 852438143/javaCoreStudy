package com.designPatterns.decorator;

/**
 * 装饰模式就是给一个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰对象实现同一个接口，装饰对象持有被装饰对象的实例
 * Source类是被装饰类，Decorator类是一个装饰类，可以为Source类动态的添加一些功能
 *
 * 1、需要扩展一个类的功能。
 2、动态的为一个对象增加功能，而且还能动态撤销。
 * Created by 85243 on 2017/3/23.
 */
public class Test {
    public static void main(String[] args) {
        Sourceable sourcetemp = new Source();
        Sourceable source = new Decorator(sourcetemp);
        source.method();
    }
}
