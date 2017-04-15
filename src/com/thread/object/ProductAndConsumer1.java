package com.thread.object;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 公园大门模式,统计一个公园总人数,一个公园多个入口,共享总人数数据
 * Created by 85243 on 2017/4/7.
 */
public class ProductAndConsumer1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es= Executors.newCachedThreadPool();
        for(int i = 0;i<5;i++){
            es.execute(new Entrance(i));
        }
        TimeUnit.SECONDS.sleep(3);
        Entrance.flag = true;
        es.shutdown();

        if(!es.awaitTermination(250,TimeUnit.MILLISECONDS)){//如果线程在250毫秒内结束,则返回true否则返回flase,并结束所有线程
            System.out.println("一些线程结束失败");
        }
        System.out.println(Entrance.count.getCount());
        System.out.println(Entrance.getSum());
    }
}

class Count{
    private int count=0;
    public int getCount(){
        return count;
    }
    synchronized public int increatemnet(){
        int temp = count;
        if(new Random().nextBoolean()){//这里的if只是为了让当前线程到就绪状态,为了使结果更明显
            Thread.yield();//把当前线程换到就绪状态,
        }
        count++;
        return count;
    }
}
class Entrance implements Runnable {
    public static Count count = new Count();
    public static boolean flag = false;
    public static List<Entrance> entrances = new ArrayList<>();
    private int num;
    private int id;
    private int sum;//这个使验证总人数是否于Count里面一样,查看线程是否出错

    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }
    public static int getSum(){
        int sum =  0;
        for(Entrance e:entrances){
            sum+=e.num;
        }
        return sum;
    }

    @Override
    public void run() {
        while (!flag) {
            synchronized (this) {
                num++;
            }
            System.out.println("#: " + id + " entrance num is: " + num + " total: " + count.increatemnet());
            try {
                TimeUnit.MILLISECONDS.sleep(100);//休眠100毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
