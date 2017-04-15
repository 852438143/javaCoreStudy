package com.thread.object;

/**
 * 多线程输出1,2,1,2,1,2
 *因为调用sleep()和yield()的时候锁并没有被释放(即进入阻塞状态),而wait将释放锁(然后进入等待状态),可以使另一个线程进入synchronized方法块,notify可以从wait中获取一个线程,恢复执行
 *
 * notify():唤醒在此对象监视器上等待的单个线程。如果所有线程都在此对象上等待，则会选择唤醒其中一个线程。
 * 选择是任意性的，并在对实现做出决定时发生。线程通过调用其中一个 wait 方法，在对象的监视器上等待。
 * Created by 85243 on 2017/4/6.
 */
public class Notify implements Runnable{
    private int num;
    private static  Object lock = new Object();//这个是静态的锁,要保证每个对象共用一个锁,才能保证同步,如果使用非静态,每个对象就新建一个锁,那么这个意义不大
    public Notify(int num) {
        this.num = num;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while(true){
            synchronized (lock){
                try {
                  System.out.println(num);//这句话写在wait后面也可以的,写在前面执行流程是:
                                    // 输出1的线程先进入同步方法块,输出num,然后notify它唤醒wait队列中的线程,发现没有线程,输出"看看语句"然后加入wait线程中,释放锁
                                    //此时输出2的线程进入同步方法块,输出num,它唤醒wait队列中的线程,发现输出1的线程,输出"看看语句",然后加入wait线程,释放锁
                                    //此时输出1的线程已被唤醒,属于可执行状态,可以与其他所有的线程竞争,但是这里只有两个线程使用这个lock对象,一个是输出1线程和输出2线程
                                    //此时输出2线程已经加入wait队列中,只有被唤醒才可以拿锁,所以输出1线程被执行,从上次暂停的地方执行,即wait后面,即输出"原来语句"
                                    //此时线程队列中只有输出1线程,所以继续拿锁,输出1线程输出1 然后唤醒线程2，输出2线程执行"原来语句"
                    lock.notify();//这里调用的使锁的notify方法,并不是Notify这个类继承自Object中的notify的这个方法,因为notify的定义就是唤醒在此对
                            // 象监视器上等待的单个线程,监视器即lock对象,同理wait方法也是监视器上面的wait方法
                    System.out.println("看看notity是直接跳到wait线程中的方法,还是等待该线程运行完呢？猜测是直接跳过去的,猜测错误: "+num);
                    lock.wait();//释放锁,给其他线程进入synchronized块中
                    System.out.println("原来不是直接跳过去,需要当前线程wait后才跳过去: "+num);
//                    System.out.println(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Notify(1);
        new Notify(2);
//        new Notify(3);
    }
}
