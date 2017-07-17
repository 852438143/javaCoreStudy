package com.jvm.chapter2;

/**3-5 新生代minorGC
 * vm option:   -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * java -verbose[:class|gc|jni] 在输出设备上显示虚拟机运行信息。
 * -Xmn  年轻代大小
 * -XX:SurvivorRatio=8   eden和survior大小比例
 * Created by 85243 on 2017/4/16.
 */
public class Demo7 {
    private static final int _1MB = 1024*1024;

    public static void main(String[] args) {
        byte[] allocation1 ,allocation2 ,allocation3,allocation4;
        allocation1 = new  byte[2*_1MB];
        allocation2 = new  byte[2*_1MB];
        allocation3 = new  byte[2*_1MB];
        allocation4 = new  byte[4*_1MB];
    }
}
