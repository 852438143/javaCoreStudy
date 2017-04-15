package com.designPatterns.factoryMethod;

/**
 * Created by 85243 on 2017/3/22.
 */
public class MessageSender implements Sender {

    @Override
    public void send() {
        System.out.println("I'm a MessageSender Object");
    }
}
