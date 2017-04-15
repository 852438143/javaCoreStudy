package com.foundation;

import org.junit.Test;

/**
 * Created by 85243 on 2017/4/15.
 */
public class StringDemo {
    /**
     * intern方法和字符串常量池
     * 当调用 intern 方法时，如果字符串常量池已经包含一个等于此 String 对象的字符串（用 equals(Object) 方法确定），
     * 则返回池中的字符串。否则，将此 String 对象添加到池中，并返回此 String 对象的引用。
     * 当且仅当 s.equals(t) 为 true 时，s.intern() == t.intern() 为 true
     */
    @Test
    public void test01(){
        String hello = "hello";//先查看字符串常量池里面是否有"hello"这个字符串,如果有的化,赋值给变量hello,否则的化,在常量池里面新建一个"hello"字符串常量,赋值给变量hello
        String hello1 = new String("hello");//无论字符串常量池中是否有"hello"都直接在内存中新建一个字符串常量"hello",所以hello==hello1为false,因为两个的引用不一样
        System.out.println("hello==hello1 : ");
        System.out.println(hello== hello1);
        //不知道为什么把这两句写道一个sout里面,里面输出的内容就出错
//        System.out.println("hello==hello1.intern: "+hello==hello1.intern());
        System.out.println("hello==hello1.intern: ");
        System.out.println(hello==hello1.intern());

        //当两个常量字符串相加的时候,默认结果也是先加入到常量池,若包含常量字符串的变量,则是直接在内存中new一个常量字符串
        String lo = "lo";
        String hello2= "hel"+"lo";//和hello都指向字符串常量池里面的"hello"字符串
        String hello3 = "hel"+lo;
        System.out.println("hello==hello2: ");
        System.out.println(hello==hello2);
        System.out.println("hello==hello3: ");
        System.out.println(hello==hello3);
        System.out.println("hello2==hello3: ");
        System.out.println(hello2==hello3);
    }
}
