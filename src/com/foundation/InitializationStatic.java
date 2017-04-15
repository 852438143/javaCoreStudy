package com.foundation;

/**
 * 对象初始化的过程
 * 先初始化静态域,在初始化静态方法,在初始化域,在初始化构造函数
 * Created by 85243 on 2017/4/6.
 */
public class InitializationStatic {
    public static void main(StringDemo[] args) {
        System.out.println("main函数进来了");
        First first = new First();

    }
    static First first =  new First();//在main函数前调用First类,
}

class Base{
    Base(String str){
        System.out.println("这个方法被构造了: "+str);
    }
}
class First {
    Base b1 = new Base("b1");
    static Base b2 = new Base("b2");
    First(){
        System.out.println("First 被构造了");
        new Base("b3");
    }
    static Base b4 = new Base("b4");
}
