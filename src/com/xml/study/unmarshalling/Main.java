package com.xml.study.unmarshalling;

import com.xml.study.hello.Hello;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by 85243 on 2017/3/6.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String xmlpath = "src\\com\\xml\\study\\unmarshalling\\demo1.xml";
        File file = new File(xmlpath);
        FileInputStream fi = new FileInputStream(file);
        try {
            Util.unmarshal(Hello.class,fi);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
