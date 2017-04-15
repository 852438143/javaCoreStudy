package com.designPatterns.adapter.interfaceAdaptor;

/** 接口适配器模式:当不希望实现一个接口中所有的方法时，可以创建一个抽象类Wrapper，实现所有方法，我们写别的类的时候，继承抽象类即可
 * Created by 85243 on 2017/3/23.
 */
public class Test {
    public static void main(String[] args) {
        //这里有点强势: Sourceable 应该时Subsourceable和SubSourceable2的爷爷,很奇妙,爷爷也可以代表孙子,即使中间使用了类
        Sourceable source1 = new SubSourceable();
        Sourceable source2 = new SubSourceable2();

        source1.method1();
        source1.method2();
        System.out.println("********我是华丽的分隔线,发现每个source只实现了一个方法*****");
        source2.method1();
        source2.method2();
    }
}
