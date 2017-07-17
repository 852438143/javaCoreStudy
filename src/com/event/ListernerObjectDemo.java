package com.event;

/**
 * Created by 85243 on 2017/6/19.
 */
public class ListernerObjectDemo implements ListernerDemo{

    EventObjectDemo eventObject;

    public ListernerObjectDemo() {
    }

    public ListernerObjectDemo(EventObjectDemo eventObject) {
        this.eventObject = eventObject;
    }

    public void change() {
        System.out.println("the liseterner is running");
        eventObject.start();
    }


}
