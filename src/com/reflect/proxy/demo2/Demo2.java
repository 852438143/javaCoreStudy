package com.reflect.proxy.demo2;

import org.junit.Test;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 */
public class Demo2 {
    /**
     * 查看代理类动态生成的类
     * 需要实现同一个接口
     *  默认调用java.lang.Object中的 hashCode、equals 或 toString 而不是接口或者给目标对象中的
     */
    @Test
    public void test01(){
        Class  proxyClazz = Proxy.getProxyClass(Collection.class.getClassLoader(),Collection.class);
        Constructor[] constructors = proxyClazz.getConstructors();
        System.out.println("代理类的构造函数");
//        单线程使用StringBuilder
        StringBuilder sb = new StringBuilder();
        for(Constructor constructor :constructors){
            sb.append(constructor.getAnnotatedReturnType()).append(" ");
            sb.append(constructor.getName()).append(" ");
            Parameter[] parameters = constructor.getParameters();
            for(Parameter parameter: parameters){
                sb.append(parameter.getType()+"  ");
                sb.append(parameter.getName()).append("  ");
            }
        }
        System.out.println(sb.toString());
        System.out.println("所有方法");
        sb = new StringBuilder();
        Method[] methods = proxyClazz.getMethods();
        for(Method method : methods){
            sb.append(method.getName());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    /**
     * 使用代理类的构造方法,初始化一个类,这个类的某些方法不能被调用
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    @Test
    public void test02() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazzProxy = Proxy.getProxyClass(Collection.class.getClassLoader(),Collection.class);
        //因为没有无参构造方法,所以不能使用newInstance方法
//        Collection collection = (Collection) clazzProxy.newInstance();
//        由上面的可知,clazzProxy有一个构造方法
//      sun.reflect.annotation.AnnotatedTypeFactory$AnnotatedTypeBaseImpl@694f9431 com.sun.proxy.$Proxy4 interface java.lang.reflect.InvocationHandler  arg0
//        参数类型为InvocationHandler
        class MyInvocationHandler implements InvocationHandler{
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        }
        Collection collection = (Collection) clazzProxy.getConstructors()[0].newInstance(new MyInvocationHandler());
        //发现输出的是null,但是发现collection.clear()方法可以被调用,且没有被抛出异常,但是collection.size()出现空指针异常
        //因为下面调用的所有方法都是运行InvocationHandler里面的invoke方法,如果这个方法里面调用了空的对象,则抛出空指针异常
        System.out.println(collection);
        collection.clear();
        collection.size();
    }


    /**
     * 直接创建一个代理类对象
     */
    @Test
    public void test03(){
        Collection collection = (Collection) Proxy.newProxyInstance(Collection.class.getClassLoader(), new Class[]{Collection.class},
                new InvocationHandler() {
                    List list = new ArrayList();
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(method.getName()+" is running");
                        Object result = method.invoke(list,args);
                        return result;
                    }
                });
        //这里面没有抛出异常的原因在于里面有了个对象,这个对象被初始化,所以没有抛出空指针异常
        collection.add("aaa");
        collection.add("vvv");
        System.out.println(collection.size());
    }


    /**
     * 局部内部类使用外部变量需要使用final修饰
     * 因为生命周期的原因。方法中的局部变量，方法结束后这个变量就要释放掉，final保证这个变量始终指向一个对象。

     首先，内部类和外部类其实是处于同一个级别，内部类不会因为定义在方法中就会随着方法的执行完毕而跟随者被销毁。
     问题就来了，如果外部类的方法中的变量不定义final，那么当外部类方法执行完毕的时候，这个局部变量肯定也就被GC了，
     然而内部类的某个方法还没有执行完，这个时候他所引用的外部变量已经找不到了。如果定义为final，java会将这个变量
     复制一份作为成员变量内置于内部类中，这样的话，由于final所修饰的值始终无法改变，所以这个变量所指向的内存区域就不会变。
     */

    /**
     * 新建一个通用的代理类
     * 这个
     *
     * 讲道理这里的参数需要使用final,因为target和advice属于InvocationHandler新建的匿名内部类的外部变量，需要final修饰,这里不知道为什么不写也不会出错
     */
    public Object getProxy(final Object target,final Advice advice){
        Object proxy= Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                advice.beforeMethod(method,args);
                Object result = method.invoke(target,args);
                advice.afterMethod(method,args);
                return result;
            }
        });
        return proxy;
    }

    /**
     * 使用通用的代理方法,获取代理类,在spring  Aop中只用编写advice方法,就可以实现切面编程
     */
    @Test
    public void test04(){
        Collection collection = (Collection) getProxy(new ArrayList<>(),new MyAdvice());
        collection.add("aa1la");
        System.out.println();
        collection.add("bb");
        System.out.println();
        System.out.println(collection.size());
    }


    /**
     * 查看动态代理类的超类是不是Proxy
     *
     */
    @Test
    public void test05(){
        Class clazzProxy = Proxy.getProxyClass(Collection.class.getClassLoader(),Collection.class);
        System.out.println(clazzProxy.getName()+" 父类是 "+clazzProxy.getSuperclass().getName());
    }


}
