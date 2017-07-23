package com.event;

import java.util.EventObject;

/**
 * Created by 85243 on 2017/6/19.
 */
public class EventObjectDemo extends EventObject{

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public EventObjectDemo(Object source) {
        super(source);
    }
    public void start(){
        System.out.println("Event is started !!!");
    }
}
