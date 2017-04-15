package com.designPatterns.factoryMethod;

/**
 * 工厂方法模式,通过创建一个工厂类对实现了同一接口的一些类进行实例创建
 * EmailSender and MessageSender 继承了Sender 并使用SenderFactory实例化对象
 * 一般情况下我们使用静态工厂方法,不用实例化工厂类;也可以直接把工厂方法写在所实例化的类中(本例中的EmailSender...中)
 *一般使用工厂方法需要把构造函数变为private,意味着这个类不能用new,和扩展该类,因为private没办法被继承
 *
 *
 * 下列情况可以考虑使用工厂方法模式：
        创建对象需要大量重复的代码。
        创建对象需要访问某些信息，而这些信息不应该包含在复合类中。
        创建对象的生命周期必须集中管理，以保证在整个程序中具有一致的行为。
 * Created by 85243 on 2017/3/22.
 */
public class TestFactory {
    public static void main(String[] args) {
        SenderFactory sf = new SenderFactory();
        Sender sender = sf.produce("email");
        sender.send();
    }
}
