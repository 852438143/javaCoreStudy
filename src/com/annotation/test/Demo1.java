package com.annotation.test;

import com.annotation.AnnotationDemo1;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * Created by 85243 on 2017/4/9.
 */
public class Demo1 {
    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        Demo demo = new Demo();
        Field field = Demo.class.getField("user");
        if(field.isAnnotationPresent(AnnotationDemo1.class)){
//            调用了AnnotationDemo1的name方法返回了一个string对象,默认的是"",或者是注解的时候的值
            String value = field.getAnnotation(AnnotationDemo1.class).name();
            //当使用private或者默认的权限的时候需要调用       field.setAccessible(true);
            field.set(demo,value);
            System.out.println(demo);
        }
    }
}
