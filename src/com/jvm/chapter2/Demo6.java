package com.jvm.chapter2;

/**3-2对象自我拯救的演示
 * 当对象要被回收前,且对象重写了finalize方法,且是第一次使用finalize方法,则可以使用finalize方法,进行一次拯救(即把对象的this关键字,赋值给一个引用,那么对象就不会被回收了)
 * Created by 85243 on 2017/4/16.
 */
public class Demo6 {
    public static Demo6  demo6 =null;
    public void isAlive(){
        System.out.println("I'm still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        demo6 = this;
    }

    public static void main(String[] args) throws InterruptedException {
        demo6 = new Demo6();

        //对象第一次成功拯救自己
        demo6 = null;//此时没有引用指向对象,会被gc回收
        System.gc();
        //因为finalize方法优先级比较低,所以线程暂停0.5秒,等待他
        Thread.sleep(500);
        if(demo6!=null){
            demo6.isAlive();
        }else{
            System.out.println("I'm dead :(");
        }

        //对象第二次失败拯救自己
        demo6 = null;//此时没有引用指向对象
        System.gc();
        //因为finalize方法优先级比较低,所以线程暂停0.5秒,等待他
        Thread.sleep(500);
        if(demo6!=null){
            demo6.isAlive();
        }else{
            System.out.println("I'm dead :(");
        }
    }
}
