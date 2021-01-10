package String;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/*
String 的使用\
    String 是引用数据类型
    String 声明为final 不可以被继承
    String 实现了Serializable 接口 表示字符串是支持序列化的
           实现的Comparable 接口 表示String可以比较大小
           内部定义了final char[]数组 value 用于存储字符串数据

    String
        代表不可变的字符序列 简称 不可变性
            当对字符串重新赋值时 string会重新创建指定内存区域赋值 不会改变原先字符串的值
            因为string是final 的数组不能声明后不能改变

        通过字面量的方式（区别于new）给一个字符串赋值此时的字符串声明在字符串常量池中
        字符串常量池中是不会存贮相同内容的字符串
        第一种方法创建字符串时
            JVM 会查看内部的缓存池是否已有相同的字符串存在：如果有，则不再使用构造函数构造一个新的字符串，
            直接返回已有的字符串实例 这两个字符串共用一个地址；若不存在，则分配新的内存给新创建的字符串 新创建一个字符串赋值。

        第二种方法直接调用构造函数来创建字符串，
            创建了2个对象一个是堆空间的new 结构 string   一个是char[]对应的常量池中的数据
            如果所创建的字符串在字符串缓存池中不存在则调用构造函数创建全新的字符串，
            如果所创建的字符串在字符串缓存池中已有则再拷贝一份到 Java 堆中。

        尽管这是一个简单明显的例子，然而在实际项目中编程者却不那么容易洞察因为这两种方式的选择而带来的性能问题。

        当对字符串重新赋值时需重新制定内存区域赋值不能使用原有的value赋值
        对现有的字符串进行连接操作时也需要重新指定内存区域赋值
        当调用replace（）方法修改指定字符或字符串时 也需要重新赋值

        //如果拼接的结果使用intern（）返回值就在常量池中
        //常量与常量的拼接结果在常量池 且常量池不会存在相同内容的常量
        //只要有一个是变量 结果就在堆中


 */
public class StringTest {
    @Test
    public void test(){
        String s = "abc";
        String s1 = "abc";//字面量赋值 依旧是2个对象只是用同一个地址
        String s5 = new String("abc");
        System.out.println(s5 == s);
        System.out.println("s1 = " + s1);
        System.out.println("s = " + s);
        System.out.println( s1 == s);//==比较对象比较的是地址值
        System.out.println(s.equals(s1));
        s = "hello";
        System.out.println( s1 == s);
        System.out.println("s1 = " + s1);
        System.out.println("s = " + s);
        System.out.println("");


        String s2 = "abc";
        s2 += "def";
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        //当对字符串重新赋值时需重新制定内存区域赋值不能使用原有的value赋值
        //对现有的字符串进行连接操作时也需要重新指定内存区域赋值
        //当调用replace（）方法修改指定字符或字符串时 也需要重新赋值
        String s3 = "abc";
        String s4 = s3.replace("a","m");
        System.out.println("s3 = " + s3);
        System.out.println("s4 = " + s4);
    }

    @Test
    public void test2(){
        String s = "java";
        String s1 = "java";
        String s2 = new String("java");
        String s3 = new String("java");
        System.out.println(s == s1);//t
        System.out.println(s1 == s2);//f
        System.out.println(s2 == s3);//f
        System.out.println(s == s3);//f

}
    @Test
    public void test3(){
        String s = "java";
        String s1 = "ee";

        String s2 = "javaee";
        String s3 = "java" + s1;
        String s4 = s + s1;
        String s5 = "java" + "ee";
        //常量与常量的拼接结果在常量池 且常量池不会存在相同内容的常量
        //只要有一个是变量 结果就在堆中

        System.out.println(s2 == s3);//f
        System.out.println(s2 == s4);//f
        System.out.println(s2 == s5);//t
        System.out.println(s3 == s4);//f
        System.out.println(s4 == s5);//f
        //如果拼接的结果使用intern（）返回值就在常量池中
        String s6 = s4.intern();
        System.out.println(s2 == s6);//t
    }

    @Test
    public void test4() throws UnsupportedEncodingException {
        String str = "23";
        int num = Integer.parseInt(str);
        String s = String.valueOf(num);
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            System.out.println(c);
        }
        str = new String(charArray);
        System.out.println("str = " + str);

        //String转Byte 编码
        String str2 = "abcABC123 中国";
        byte[] bytes = str2.getBytes();//使用默认的字符集进行转换
        System.out.println(Arrays.toString(bytes));

        byte[] gbk = str2.getBytes("gbk");
        System.out.println(Arrays.toString(gbk));

        //解码 编码集解码集必须一致
        str2 = new String(bytes);//默认字符集
        System.out.println(str2);

        str2 = new String(gbk);
        System.out.println(str2);

        str2 = new String(gbk,"gbk");
        System.out.println(str2);
    }

}
