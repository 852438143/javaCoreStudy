package com.foundation;

import java.util.Date;

/**
 * 了解方法参数的值传递
 * 不是单纯的引用传递
 * 是对象引用值传递
 * 只是user1和parameterUser1变量指的是同一个对象，
 * 调用swap方法只是改变了parameterUser1和parameterUsers2的所指对象
 * 关于String类型，因为String对象的不可变性，其实也是引用值传递，
 * Integer 类型也是这样的，对象包装器(wrapper)是不可变的，一旦构造了就不可以改变其中的值，所以传值的时候也要小心
 * 对于Integer类型可以使用org.omg.CORBA.IntHolder作为方法参数，然后参数使用的x.value可以修改对象的值
 * 不过每次的（str = "aaaa"）都是直接个String变量重新新建一个对象
 * Created by 85243 on 2017/3/7.
 */
public class MethodParameter {
    public static void main(StringDemo[] args) {
        User user1 = new User("user1", new Date());
        User user2 = new User("user2", new Date());
        System.out.println("before swap : user1 is : " + user1+"   user2 is : " + user2);
        swap(user1,user2);
        System.out.println("after swap : user1  is : " + user1 + "  user2 is : " + user2);
    }
    public static void swap(User parameterUser1,User parameterUser2){
         User temp = parameterUser1;
        parameterUser1 = parameterUser2;
        parameterUser2 = temp;
        System.out.println("after swap :  parameterUser1 is : " + parameterUser1 + "  parameterUser2 is : " + parameterUser2);

    }
}
