package com.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by yangliwei on 2017/7/23.
 */
public class FileDemo {


    /**
     * 输出规范路径名
     */
    @Test
    public void testGetCanonicalPath(){
        String path = System.getProperty("user.dir")+File.separator+"webroot";
        File  file = new File(path);
        try {
            String fileCanonicalPath = file.getCanonicalPath();
            System.out.println(fileCanonicalPath);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
