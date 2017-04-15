package com.designPatterns.factoryMethod;

/**
 *
 * Created by 85243 on 2017/3/22.
 */
public class SenderFactory {
    public Sender produce(String type){
        if(type.equals("email")){
            return new EmailSender();
        }
        else if(type.equals("message")){
            return new MessageSender();
        }
        else {
            System.out.println("the type is error !");
            return null;
        }
    }
}
