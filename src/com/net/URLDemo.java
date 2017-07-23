package com.net;

import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by yangliwei on 2017/7/23.
 */
public class URLDemo {

    /**
     * 目测URL参数protocal 有ftp, http, nntp,flie
     *
     * 该方法新建一个基于file协议的url连接，
     */
    @Test
    public void testURL(){
        String protocal = "file";
        String host = "127.0.0.1";
        String file = System.getProperty("user.dir");
        try {
            URL url = new URL(protocal,host, File.separator+file);
//            file://127.0.0.1\D:\ideaProject\javaStudy
            System.out.println(url.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
