package com.thread;

import java.util.Random;

/**
 * Created by 85243 on 2017/4/7.
 */
public class ThreadLocalDemo1 {
    //以下是静态变量,讲道理应该是在初始化的时候就确定值了,但是貌似ThreadLocal是一个map对象,所以这里面value确实在第一次初始化的时候初始化了,
    //然后在之后的每个线程启动的时候向map里面添加数据,可以选择debug下,debug下发现,先初始化了一个value对象,然后每个线程在调用value.get方法后,有个setInitailValue方法向map里面添加键值对,然后获取
    //所以每个线程都有一个针对于自己线程的值
    public static ThreadLocal<Integer>  value = new ThreadLocal<Integer>(){//重写ThreadLocal里面的initialValue方法
       public Integer initialValue(){
           return new Random().nextInt(1000);
       }
    };

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+" "+value.get());
        for(int i = 0;i<10 ;i++){
            new Thread(){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+ " "+ThreadLocalDemo1.value.get());
                }
            }.start();
        }
    }
}
