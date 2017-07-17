package com.lang.ref;

import org.junit.Test;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * Created by 85243 on 2017/6/19.
 */
public class Demo01 {
    @Test
    public void test01(){

//        里面内容及其复杂,在Reference类里面各种瞎鸡巴操作,最后又特么调到LocaleObjectCache里面去了.
//        所以看到SoftReference类会比Demo01先运行,就是在类加载的时候,Reference里面的静态函数瞎鸡巴搞
        ReferenceQueue queue = new ReferenceQueue();
        Reference reference = new SoftReference(new String("aaa"),queue);
        Object obj = reference.get();
    }
}
