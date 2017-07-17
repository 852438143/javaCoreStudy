package com.think.chapter18.test;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * 针对File类的一些方法的调用
 * Created by 85243 on 2017/4/28.
 */
public class Demo {
    @Test
    public void test01(){
        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);
        assert(true);
        System.out.println("我被 执行了  当assert为true时继续执行,否则抛出AssertionError");
        assert(false);
    }
    @Test
    public void test02(){
//       .  相当于当前目录下面的文件,切当前目录为D:\ideaProject\javaStudy   =>System.getProperty("user.dir");
        File file  = new File(".");
        String[] str = file.list();
        for(String temp:str){
            System.out.println(temp);
        }
        System.out.println("当前文件目录:  "+file.getPath());
    }

    /**
     * 使用过滤器，这个要根据file源码里面的内容来判断如何使用过滤器
     */
    @Test
    public void test03(){
        File file = new File(System.getProperty("user.dir"));
        //显示当前目录下面所有文件,不包括目录
//        使用了FileFilter过滤器,关于这个过滤器的作用,分析File类里面的listFiles()方法,

/*        public File[] listFiles(FileFilter filter) {
            String ss[] = list();
            if (ss == null) return null;
            ArrayList<File> files = new ArrayList<>();
            for (String s : ss) {
                File f = new File(s, this);
                if ((filter == null) || filter.accept(f))
                    files.add(f);
            }
            return files.toArray(new File[files.size()]);
        }*/
//    只是这里面的时把file里面的所有文件和目录,赋值到filter.accept(f)中,然后判断filter.accept()的返回值

        System.out.println("使用匿名内部类,获取当前目录下面的所有文件类型的文件");
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile()?true:false;
            }
        });
        for(File temp: files){
            System.out.println(temp.getPath());
        }

//        因为是匿名内部类,所以可以是用lambda表达式

        System.out.println("使用lambda表达式获取当前目录下面的所有目录类型的目录");
        File[] filesLambda = file.listFiles((File o) -> o.isDirectory()?true:false );
        for(File temp: filesLambda){
            System.out.println(temp.getPath());
        }
    }

    /**
     * 返回以b开头的所有文件或目录
     */
    @Test
    public void test04(){
        File file = new File(System.getProperty("user.dir"));
        String[] files = file.list((File dir,String name)->{
           Pattern pattern = Pattern.compile("b.*");

            boolean result = pattern.matcher(name).matches();
            return result;
        });
        for(String tempFile:files){
            System.out.println(tempFile);
        }
    }

    /**
     * 显示所有的系统属性
     */
    @Test
    public void test05(){
        Properties properties = System.getProperties();
        properties.list(System.out);
    }

    /**
     * 由一个协议等于file的uri组成
     * @throws URISyntaxException
     */
    @Test
    public void test06() throws URISyntaxException {
        File file  = new File(new URI("http://www.baidu.com"));
        System.out.println(file.getName());

    }

}
