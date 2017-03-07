package com.xml.study.unmarshalling;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

/**
 * Created by 85243 on 2017/3/6.
 */
public class Util {
    public static <T> T unmarshal(Class<T> docClass, InputStream inputStream) throws JAXBException {
        String packageName = docClass.getPackage().getName();
        System.out.println("packaggName "+packageName);
        JAXBContext jc = JAXBContext.newInstance(packageName);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        JAXBElement<T> doc = (JAXBElement<T>) unmarshaller.unmarshal(inputStream);
        System.out.println(doc.toString());
        System.out.println(doc.getName());
        System.out.println(doc.getValue().toString());
        return doc.getValue();
    }
}
