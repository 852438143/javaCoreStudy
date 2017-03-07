package com.generic.study;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 85243 on 2017/2/20.
 */
public class Demo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("hello");
        String s = list.get(0);   // no cast
    }
}
