package com.foundation.study;

/**
 * Created by 85243 on 2017/2/28.
 */
public class Demo1 {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c =1;
        //等价于 a+=(b+=c);右结合运算符
        a+=b+=c;
        System.out.println("a:"+a+" b:"+b+" c:"+c);
    }
}
