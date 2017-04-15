package com.foundation;

/**
 * final关键字,主要是field
 * Created by 85243 on 2017/4/6.
 */
public class Final {
    final String a ="a";
    static final String b  ="b";
    final Value a1  =new Value(1);//不能修改a1的引用
    static Value b1 = new Value(2);
    final String c;//空白final,在对象初始化的时候,时候初始化
    final Value d;

    public Final() {
        c = "c";
        d = new Value(3);
        System.out.println("Finale is construct");
    }
    public  void get(final Value v){
//        v = new Value(111); //这个形参不能改变引用
        v.a=2;
    }

    public static void main(StringDemo[] args) {
        Final f = new Final();
//        基本变量再次修改
//        System.out.println(f.a );
//        f.a = "aaaaaa";
//        System.out.println(f.a );

        System.out.println(f.a1.a );
        f.a1.a = 0;
        System.out.println(f.a1.a );

        System.out.println(Final.b1.a);
        Final.b1.a=0;
        System.out.println(Final.b1.a );

        System.out.println(f.d.a );
        f.d.a = 0;
        System.out.println(f.d.a );
    }
}
class Value{
    public int a ;

    public Value(int a) {
        this.a = a;
        System.out.println("value : "+a);
    }
}
