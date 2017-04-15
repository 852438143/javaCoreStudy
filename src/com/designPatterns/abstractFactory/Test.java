package com.designPatterns.abstractFactory;

/**
 * 2、抽象工厂模式（Abstract Factory）
     工厂方法模式有一个问题就是，类的创建依赖工厂类，也就是说，如果想要拓展程序，必须对工厂类进行修改，
    这违背了闭包原则(对扩展开放，对修改关闭。在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果。)，
    所以，从设计角度考虑，有一定的问题，如何解决？就用到抽象工厂模式，创建多个工厂类，
    这样一旦需要增加新的功能，直接增加新的工厂类就可以了，不需要修改之前的代码。

    此例中: 依旧是EmailSender和MessageSender继承Sender接口
    Provider接口定义了produce方法,子类工厂方法(EmailSenderFactory和MessageSenderFactory)继承了该接口,这样只要扩展该接口就可以实现新的类,无需改动原有代码
 * Created by 85243 on 2017/3/22.
 */
public class Test {
    public static void main(String[] args) {
        Provider provider = new EmailSenderFactory();
        Sender sender = provider.produce();
        sender.send();
    }
}
