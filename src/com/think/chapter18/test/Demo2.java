package com.think.chapter18.test;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;

/**
 * nio里面的方法理解与对channels的使用
 * 1）面向块的I/O
 * 传统JavaIO是面向流的I/O。流I/O一次处理一个字节。NIO则是面向块的I/O，每次操作都是以数据块为单位。
 * NIO中引入了缓冲区（Buffer）的概念，缓冲区作为传输数据的基本单位块，所有对数据的操作都是基于将数据移进/移出缓冲区而来；
 * 读数据的时候从缓冲区中取，写的时候将数据填入缓冲区。尽管传统JavaIO中也有相应的缓冲区过滤器流（BufferedInputStream等），
 * 但是移进/移出的操作是由程序员来包装的，它本质是对数据结构化和积累达到处理时的方便，并不是一种提高I/O效率的措施。 NIO的缓冲区则不然，
 * 对缓冲区的移进/移出操作是由底层操作系统来实现的。通常一次缓冲区操作是这样的：某个进程需要进行I/O操作， 它执行了一次读（read）或者写
 * (write)的系统调用，向底层操作系统发出了请求，操作系统会按要求把数据缓冲区填满或者排干。 说起来简单，其实很复杂。但至少我们知道了这事
 * 是由操作系统干的，比我们代码级的实现要高效的多。 除了效率上的差别外，缓冲区在数据分析和处理上也带来的很大的便利和灵活性
 * 2）非阻塞的I/O + 就绪性选择
 * 传统JavaIO是基于阻塞I/O模型的：当发起一个I/O请求时，如果数据没有准备好（read时无可读数据，write时数据不可写入）， 那么线程便会阻塞，
 * 直到数据准备好，导致线程大部分的时间都在阻塞。 而非阻塞I/O则允许线程在有数据的时候处理数据，没有数据的时候干点别的，提高了资源利用率。
 * 就绪性选择通常是建立在非阻塞的基础上，并且更进一步，它把检查哪些I/O请求的数据准备好这个任务交给了底层操作系统， 操作系统会去查看并返
 * 回结果集合，这样我们只需要关心那些准备好进行操作的IO通道。
 * 3）文件锁定和内存映射文件等操作系统特性
 * NIO同时带来了很多当今操作系统大都支持的特性。 文件锁定是多个进程协同工作的情况下，要协调进程间对共享数据的访问必不可少的工具。 内存映射
 * 利用虚拟内存技术提供对文件的高速缓存，使读取磁盘文件就像从内存中读取一样高效， 但是却不会有内存泄漏的危险，因为在内存中不会存在文件的完整拷贝。
 * Created by 85243 on 2017/4/30.
 */
public class Demo2 {

    /**
     * 内存映射文件，直接操作文件
     * 发现fc传输比旧io传输块,等等详细分析,
     *
     * @throws FileNotFoundException
     */
    @Test
    public void test01() throws IOException {
        final int num = 400005;
        long start, end;


        start = new Date().getTime();
        FileOutputStream fileOutputStream = new FileOutputStream("out.txt");
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        for (int i = 0; i < num; i++) {
            dataOutputStream.writeInt(i);
        }
        end = new Date().getTime();
        fileOutputStream.close();
        System.out.println(end - start);


        start = new Date().getTime();
        RandomAccessFile file = new RandomAccessFile("out.txt", "rw");
        FileChannel fileChannel = file.getChannel();
//        System.out.println(fileChannel.size());
        IntBuffer intBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size()).asIntBuffer();
        for (int i = 0; i < num; i++) {
            intBuffer.put(i);
//            System.out.println(i);
        }
        fileChannel.close();
        end = new Date().getTime();
        System.out.println(end - start);
    }

    /**
     * 待测试对象所需要实现的接口
     */
    abstract class TestObject {
        abstract void test() throws IOException;

        /**
         * 待测试对象所用时间
         */
        public void useTime() throws IOException {
            long start, end;
            start = new Date().getTime();
            this.test();
            end = new Date().getTime();
            System.out.println("使用时间：" + (end - start));
        }
    }


    /**
     * 测试FileInputStream,BufferedInputStream,和FileChannel中的ByteBuffer是不是单纯的因为缓存块大小所致
     * <p>
     * 1.无论读取内容大小发现使用FileInputStream比使用BufferedInputStream节省时间,说明BufferedInputerStream只是单纯的加了一个缓存buf,
     * 当作中间件,所以多一次赋值在      291行  System.arraycopy(getBufIfOpen(), pos, b, off, cnt);
     * 2.读取内容越多,FileChannle使用时间相对于前两者增加的越少,但是还是比fileInputStream多,因为ByteBuffer并没有在自身里面运用一个数组进行缓存,
     *      而是直接自己设置缓存大小,并用了一个数据结构,很复杂
     * 3.内存映射文件是最快的,但是不知道原理,应该和操作系统内核有关系,应该是直接在操作系统上面分配内存,而不是在jvm上面
     *      NIO 的创建目的是为了让 Java 程序员可以实现高速 I/O 而无需编写自定义的本机代码。NIO 将最耗时的 I/O 操作(即填充和提取缓冲区)转移回操作系统，
     *      因而可以极大地提高速度。
     */
    @Test
    public void test02() throws IOException {
        final int byteLong = 1600020;
        File file = new File("out.txt");
        TestObject[] testObjects = {
                new TestObject() {
                    @Override
                    public void test() throws IOException {
                        System.out.println("直接使用fileInputStream读取");
                        FileInputStream fis = new FileInputStream(file);
                        byte[] b = new byte[byteLong];
                        fis.read(b, 0, byteLong);
                        fis.close();
                        System.out.println(b[7] + " " + b[54 * 16 - 1] + " " + b[202 * 16 - 1] + " " + b[byteLong - 1]);
                    }
                },
                new TestObject() {
                    @Override
                    public void test() throws IOException {
                        System.out.println("使用BufferedInputStream读取");
                        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file), byteLong);
                        byte[] b = new byte[byteLong];
                        bf.read(b, 0, byteLong);
                        bf.close();
                        System.out.println(b[7] + " " + b[54 * 16 - 1] + " " + b[202 * 16 - 1] + " " + b[byteLong - 1]);
                    }
                },
                new TestObject() {
                    @Override
                    public void test() throws IOException {
                        System.out.println("使用FileChannel读取");
                        FileChannel fc = (new FileInputStream(file)).getChannel();
                        ByteBuffer bbf = ByteBuffer.allocate(byteLong);
                        fc.read(bbf);
                        fc.close();
                        System.out.println(bbf.get(7) + " " + bbf.get(54 * 16 - 1) + " " + bbf.get(202 * 16 - 1) + " " + bbf.get(byteLong - 1));
                    }
                },
                new TestObject() {
                    @Override
                    void test() throws IOException {
                        System.out.println("使用MappedByteBuffer读取");
                        FileChannel fc = (new FileInputStream(file)).getChannel();
                        //这里面需要注意的是,只读的话不能改变文件大小,读写的话,需要有实现了OutputStream的FileChannel
                        ByteBuffer bbf = fc.map(FileChannel.MapMode.READ_ONLY,0,fc.size());
//                        System.out.println(fc.size());
                        System.out.println(bbf.get(7) + " " + bbf.get(54 * 16 - 1) + " " + bbf.get(202 * 16 - 1) + " " + bbf.get(byteLong - 1));
                        fc.close();
                    }
                }
        };
        for (int i = 0; i < testObjects.length; i++) {
            testObjects[i].useTime();
        }
    }

    @Test
    public void test03() throws IOException {
        final int byteLong = 400000000;
        File file = new File("out.txt");
        new TestObject() {
            public void test() throws IOException {
                System.out.println("使用FileChannel读取");
                FileChannel fc = (new FileInputStream(file)).getChannel();
                ByteBuffer bbf = ByteBuffer.allocate(byteLong);
                fc.read(bbf);
                fc.close();
                System.out.println(bbf.get(7) + " " + bbf.get(54 * 16 - 1) + " " + bbf.get(202 * 16 - 1) + " " + bbf.get(byteLong - 1));
            }
        }.useTime();


    }

    @Test
    public void test04() throws IOException {
        final int byteLong = 400000000;
        File file = new File("out.txt");
        new TestObject() {
            @Override
            public void test() throws IOException {
                System.out.println("直接使用fileInputStream读取");
                FileInputStream fis = new FileInputStream(file);
                byte[] b = new byte[byteLong];
                fis.read(b, 0, byteLong);
                fis.close();
                System.out.println(b[7] + " " + b[54 * 16 - 1] + " " + b[202 * 16 - 1] + " " + b[byteLong - 1]);
            }
        }.useTime();
    }

}
