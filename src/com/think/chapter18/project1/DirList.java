package com.think.chapter18.project1;

import net.mindview.util.TextFile;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * 查看该目录下面的文件或者目录里面包含某个单词
 * Created by 85243 on 2017/4/29.
 */
public class DirList {
    public static void main(String[] args) {
        String str = "src";
        File file = new File(System.getProperty("user.dir"));
        String[] fileNames = file.list((dir, name) -> {
            if (name.equals(str)) {
                return true;
            } else {
                if(new File(dir,name).isFile()) {
                    Set<String> set = new HashSet<>(new TextFile(new File(dir, name).getAbsolutePath(), "\\W+"));
                    if (set.contains(str))
                        return true;
                    else return false;
                }else
                    return false;
            }
        });
        for(String tempStr : fileNames){
            System.out.println(tempStr);
        }
    }
}
