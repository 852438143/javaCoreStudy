package com.thread.object;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 一个生产者,多个消费者的模型,自己乱写的
 * Created by 85243 on 2017/4/7.
 */
public class ProductAndConsumer {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        Object lock = new Object();
        Product p = new Product(0,lock);
        es.execute(p);
        for(int i=1;i<10;i++){
            Consumer con = new Consumer(i,lock);
            es.execute(con);
        }
        es.shutdown();
    }
}

class Parent{
    public static int a  = 0;
    public static boolean flag = false;//判断内存是否满了,如果没有满的话,继续生产,否则停止
}
class Product extends Parent implements Runnable{
//    public static int a= 1;  //如果不写这句,默认使用的是父类的静态变量,他和Consumer类共用父类的静态变量,这里使用父类的a当作共享数据,实现生产者消费之模型
    final int  id ;
    final private Object lock;

    Product(int id ,Object lock) {
        this.id = id;
        this.lock = lock;
    }

    @Override
    public void run() {
        while(true) {
            while (!flag) {
                synchronized (lock) {
                    a++;
                    System.out.println(id+" 生产a中 ：a= "+a);
                    lock.notifyAll();//每当生产一个a就通知等待的消费者,可以消费了
                    if (a > 1000) {
                        lock.notifyAll();//当生产导致内存不足时,告诉消费者,并且改变状态,并且停止生产
                        flag = true;
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
class Consumer extends Parent implements Runnable{
    final int id ;
    final Object lock;

    public Consumer(int id, Object lock) {
        this.id = id;
        this.lock = lock;
    }

    @Override
    public void run() {
        while(true){
            synchronized (lock){
                while (a>0){
                    a--;
                    System.out.println(id+" 消耗a中 ：a= "+a);
                    flag = false;//每当消费了一个之后,改变状态,代表内存没有满,可以生产了,并通知等待的线程(其中包括生产者和消费者),
                    lock.notify();
                }
            }
        }
    }
}
