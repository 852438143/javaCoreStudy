package com.foundation;

/**
 * 简单的把enum类变成静态常量
 * Created by 85243 on 2017/3/7.
 */
public class EnumClass {
    public static void main(StringDemo[] args) {
        String str = "SMALL";
        Size size = Enum.valueOf(Size.class,str);
        System.out.println(size);
    }
}
enum Size{
    SMALL,MEDIUM,LARGE;

}
