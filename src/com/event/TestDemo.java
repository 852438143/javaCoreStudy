package com.event;

import org.junit.Test;

/**
 * 这里使用了一个简单的观察者模式,貌似这个实现和EventObject和EventListerner两个类关系不大,
 * 容我思考下,
 * Created by 85243 on 2017/6/19.
 */
public class TestDemo {
    @Test
    public void test(){
        /*
            这个程序相当于一个触发器,当程序执行时通知,监听器,监听器触发事件.
         */
        ListernerDemo listernerDemo = new ListernerObjectDemo(new EventObjectDemo(new String("aaa")));
        listernerDemo.change();
    }
}
