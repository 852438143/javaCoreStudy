package com.jvm.chapter2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 85243 on 2017/4/15.
 */
public class Demo1 {
    /**
     * 内存溢出异常测试,
     * Xms堆的最小值,Xmm堆的最大值
     */
    //vm args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
    //把后面的参数填到vm options中
    @Test
    public void test01(){
        List<People> list = new ArrayList<>();
        while(true){
            list.add(new People());
        }
    }
}
class People {

}
