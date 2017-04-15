package com.designPatterns.adapter.classAdapter;

/**
 * 类的适配器模式: 将Source的功能扩展道Targetable
 * 当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，创建一个新类，继承原有的类，实现新的接口即可
 * Adaptor类通过继承Source 和实现Targetable 让source的功能扩展到Targetable里面去了
 * Created by 85243 on 2017/3/23.
 */
public class Test {
    public static void main(String[] args) {
        Targetable targetable = new Adaptor();
        targetable.method1();
        targetable.method2();
    }
}
