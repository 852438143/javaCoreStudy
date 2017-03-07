package com.xml.study.hello;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Hello {

    private ObjectFactory of;
    private GreetingListType grList;

    public Hello() {
        of = new ObjectFactory();
        grList = of.createGreetingListType();
    }

    public void make(String t, String l) {
        GreetingType g = of.createGreetingType();
        g.setText(t);
        g.setLanguage(l);
        grList.getGreeting().add(g);
    }

    public void marshal() {
        try {
            JAXBElement<GreetingListType> gl =
                    of.createGreetings(grList);
            //JAXBContext jc = JAXBContext.newInstance("hello");
            //这个hello文件很奇怪的，应该是路径
            JAXBContext jc = JAXBContext.newInstance("com.xml.study.hello");
            Marshaller m = jc.createMarshaller();
            m.marshal(gl, System.out);
        } catch (JAXBException jbe) {
            // ...
        }
    }
}