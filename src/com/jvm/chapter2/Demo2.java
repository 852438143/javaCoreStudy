package com.jvm.chapter2;

/**
 * 栈溢出测试 StackOverflowError
 *
 * 栈容量参数: -Xss
 *
 * 通过递归,不断进栈,实现了栈溢出,这里设置的vm参数为Xss128k,把栈的内存设置小实现溢出快点
 * Created by 85243 on 2017/4/15.
 */
public class Demo2 {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        try {
            demo2.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: "+demo2.stackLength);
            throw e;
        }
    }
}
