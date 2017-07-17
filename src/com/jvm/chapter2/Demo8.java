package com.jvm.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 以64kb/50毫秒向java堆中填充数据,使用jconsolo查看
 * Created by 85243 on 2017/4/16.
 */
public class Demo8 {
    public byte[] place = new byte[1024*64];
    public static void main(String[] args) throws InterruptedException {
        List<Demo8> lists= new ArrayList<>();
        for(int i = 0;i<1000;i++){
            Thread.sleep(50);
            lists.add(new Demo8());
        }
        System.gc();
    }
}
