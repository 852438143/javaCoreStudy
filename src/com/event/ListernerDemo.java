package com.event;

import java.util.EventListener;

/**
 * 事件监听接口
 * Created by 85243 on 2017/6/19.
 */
public interface ListernerDemo extends EventListener {

    /**
     * 该监听类的要实现的方法,EvenetListener这个必需使用一个接口,貌似是和观察者设计模式有关系
     */
    public void change(EventObjectDemo eventObject);

}
