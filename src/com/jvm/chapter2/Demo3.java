package com.jvm.chapter2;

/**
 * 因为内存光了就死机了,所以不要尝试
 * 通过实现多线程,每个线程都有自己的私有栈,多线程把内存空间占满了,导致没有内存,会出现OutOfMemoryError
 * 这里把虚拟机参数设置为-Xss2m把每个栈的容量设置大一点,这样比较块就把内存消耗光了
 *
 * Created by 85243 on 2017/4/15.
 */
public class Demo3 {
    /*
    使每个线程都一直运行,
     */
    public void running(){
        while(true){

        }
    }

    public static void main(String[] args) {
        while(true){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new Demo3().running();
                }
            }).start();
        }
    }
}
