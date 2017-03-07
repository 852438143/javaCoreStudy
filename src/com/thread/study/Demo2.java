package com.thread.study;

/**
 * Created by 85243 on 2017/2/20.
 */
public class Demo2 {
    public static void main(String[] args) {
        YellowCow yc = new YellowCow();
        new Thread(yc).start();
        new Thread(yc).start();
    }
}

class YellowCow implements Runnable {
    private int count = 20;
    private Object obj = new Object();

    @Override
    public void run() {
        method1();
    }
    private synchronized static void method2(){
        //此时的同步锁是YelloCow.class这个，因为是静态方法
    }
    private synchronized void  method1(){
        //通过同步方法，此时的同步锁是this，该类的this
        while (true) {
            if (count < 0) {
                break;
            }
            for (int i = 0; i < count; i++) {
                try {
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + "   " + count--);
            }
        }
    }
/*
    @Override
    public void run() {//不加同步锁导致多出现了一个数字0；当count等于1时，第一个线程进入while并且跳过第一个for循环，
        // 此时线程1进入休眠此时count还是等于1，这个时候第二个线程还是可以进入循环，并且执行下去，这样导致了多了一个数据，出现线程不安全
        while (true) {
            if (count < 0) {
                break;
            }
            for (int i = 0; i < count; i++) {
                try {
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + "   " + count--);
            }
        }
    }
 */
/*
    @Override
    public void run() {
        synchronized(obj){//使用同步代码锁，obj相当于一个锁，当线程访问该代码时，如果obj被加上锁了就阻塞，没加上锁就加上锁，并且进入代码块
            //此obj和count是线程的公用的，如果该对象是每个线程自身的就无法实现线程安全

            while (true) {
                if (count < 0) {
                    break;
                }
                for (int i = 0; i < count; i++) {
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getId() + "   " + count--);
                }
            }
        }
    }
 */
}
