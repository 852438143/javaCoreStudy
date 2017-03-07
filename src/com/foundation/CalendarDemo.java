package com.foundation;

import java.text.DateFormatSymbols;
import java.util.Calendar;

/**
 *
 * 打印日历
 * Calendar这个类很奇怪的，monthOfYear 是从0-11,
 * 然而dayOfWeek是从1-7的且起点是sun
 * 类似这样的
 *  星期日       星期一       星期二       星期三       星期四       星期五       星期六
 *  1             2              3              4          5             6          7
 *  然而在本地语言环境下使用的是星期一在第一天
 *  没事们技巧，就是这个类很坑，有点晕
 * Created by 85243 on 2017/3/6.
 */
public class CalendarDemo {
    public static void main(String[] args) {

        int dayOfMouth;
        int mouthOfYear;
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
        cal.set(Calendar.MONTH,1);
        dayOfMouth = cal.get(Calendar.DAY_OF_MONTH);

        mouthOfYear = cal.get(Calendar.MONTH);
        cal.add(Calendar.DAY_OF_MONTH,-dayOfMouth+1);
        //这个月的开始的第一天在星期几
        int startDayOfWeek  = cal.get(Calendar.DAY_OF_WEEK);
        //星期的第一天计算从哪开始，默认从星期天开始sun对应1
        int firstDayOfWeek =  cal.getFirstDayOfWeek();
        String[] weekDayName = new DateFormatSymbols().getShortWeekdays();
        System.out.println("weekDayName lengtg :  "+weekDayName.length);
        //这个东西前面不知道为什么有个空字符串，真是日狗了，因为默认的从星期日打到星期六，所以也需要改一下
        int temp = 0 ;
        for(int i = 1;i<weekDayName.length;i++){
            temp = (i+firstDayOfWeek)%8;
            if(temp == 0){
                temp++;
            }
            System.out.printf("%10s",weekDayName[temp]);
        }
        System.out.println();
        for(int i = 0;i<=startDayOfWeek-firstDayOfWeek;i++){
            System.out.print("      ");
        }
        while(cal.get(Calendar.MONTH)==mouthOfYear){
            System.out.printf("%12s",cal.get(Calendar.DAY_OF_MONTH));
            if(cal.get(Calendar.DAY_OF_WEEK)==firstDayOfWeek){
                System.out.println();
            }
            cal.add(Calendar.DAY_OF_MONTH,1);
        }
        //System.out.println(cal.getTime());
    }
}
