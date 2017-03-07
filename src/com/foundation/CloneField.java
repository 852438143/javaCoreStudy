package com.foundation;

import java.util.Date;

/**
 * 关于类里面的field的分析
 * Created by 85243 on 2017/3/7.
 */
public class CloneField {

    public static void main(String[] args) {
        User user1 = new  User("user1",new Date());
        System.out.println("user1 date is :"+ user1.getDate());
        Date d = user1.getDate();
        //给 d加上3秒，发现usr1里面的date数据也变了，因为d和user1.date都是一个date对象的引用，要消除这种现象要在getDate里面调用date.clone();
        d.setTime(d.getTime()+3*1000);
        System.out.println("after d setTime : "+d.getTime());
        System.out.println("the user1 date is : " + user1.getDate());

        //一个类的方法可以访问该类的任何对象的私有域,
        //查看User类的equals方法里面可以直接访问一个对象的私有域
        User user2 = new User("User2",new Date());
        user1.equals(user2);
    }

}
class User{
    String name;
    Date date ;

    public User(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }
    public boolean equals(User other){
        //这里直接访问了另一个User类对象的私有域
        return name.equals(other.name);
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
