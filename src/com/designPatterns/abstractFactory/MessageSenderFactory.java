package com.designPatterns.abstractFactory;

/**
 * Created by 85243 on 2017/3/22.
 */
public class MessageSenderFactory implements Provider {

    @Override
    public Sender produce() {
        return new MessageSender();
    }
}
