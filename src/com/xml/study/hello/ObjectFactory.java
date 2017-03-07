//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2017.03.05 时间 02:22:24 PM CST 
//


package com.xml.study.hello;



import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the hello package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Greetings_QNAME = new QName("", "Greetings");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: hello
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GreetingListType }
     *
     */
    public GreetingListType createGreetingListType() {
        return new GreetingListType();
    }

    /**
     * Create an instance of {@link GreetingType }
     *
     */
    public GreetingType createGreetingType() {
        return new GreetingType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GreetingListType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "Greetings")
    public JAXBElement<GreetingListType> createGreetings(GreetingListType value) {
        return new JAXBElement<GreetingListType>(_Greetings_QNAME, GreetingListType.class, null, value);
    }

}
