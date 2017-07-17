package com.jvm.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法区和运行时常量溢出
 * -XX:PermSize -XX:MaxPermSize设置方法区大小
 *
 * -XX:PermSize=1M -XX:MaxPermSize=1M
 *
 *这里使用不断往常量池里面添加数据,导致常量池溢出,常量池在方法区中
 *
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space这里显示的使堆异常,
 * 与书上讲的不符,可能是jdk1.8不支持设置方法区参数,所以没有方法区的溢出,导致堆溢出
 *
 * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=1M; support was removed in 8.0
 Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=1M; support was removed in 8.0


 * Created by 85243 on 2017/4/15.
 */
public class Demo4 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int  i = 0;
        while(true){
            list.add(String.valueOf(i).intern());//把字符串加到常量池里面
        }
    }
}
