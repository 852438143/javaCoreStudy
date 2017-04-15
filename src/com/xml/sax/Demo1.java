package com.xml.sax;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**使用java自带的dom解析,解析为dom树,可以解析xml和html(html需要使用jsoup插件)
 * 还有会发现这个里面所有的对象都是接口，讲道理里面的方法是抽象方法，
 * 发现问题，接口可以通过一个对象直接调用其方法org.w3c.dom.*里面的所有接口
 * Created by 85243 on 2017/3/15.
 */
public class Demo1 {
    //实体引用(entity reference) : &lt; &gt; &amp; &quot; &apos; < > & " ……(省略号,这个是在中文输入法里面按shift+6)
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //这里的默认路径是项目的根路径(D:\ideaProject\javaStudy\)，src\com\xml\sax
        File file = new File("src"+ File.separator+"com"+File.separator+"xml"+File.separator+"sax"+File.separator+"demo1.xml");
        Document dom = documentBuilder.parse(file);
//        Document对象获取的Attribute 是null；
//        System.out.println(dom.getAttributes());
        Element element = dom.getDocumentElement();
        while(element!=null){
            System.out.println(element.getTagName());
            if(element.hasAttributes()){
                NamedNodeMap attrs =  element.getAttributes();
                for(int i = 0; i<attrs.getLength();i++){
                    Attr attr = (Attr) attrs.item(i);
                    System.out.println("attribute name: "+attr.getName()+"  value: "+attr.getValue());
                }
            }
            if(element.hasChildNodes()){
                NodeList nodeList = element.getChildNodes();
            }
            element = (Element) element.getNextSibling();

        }
    }
}
