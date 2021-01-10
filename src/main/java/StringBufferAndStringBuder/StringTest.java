package StringBufferAndStringBuder;

import org.junit.Test;

/*
StringBuffer StringBuilder的使用
String StringBuffer StringBuilder 区别

String
    不可变的字符序列
    底层结构使用char型数组存储
    String s = new String == new char[0];
    String s = new String("abc") == new char[]{'a','b','c'};

StringBuffer
    可变的字符序列
    线程安全的 效率低
    底层结构使用char型数组存储 但是长度是16
    StringBuffer s = new StringBuffer(); char[] value = new char[16]底层创建了一个长度是16的数组
    s.append（'a'）   ==     value[0] = 'a';
    s.append('b')    ==     value[1] = 'b';
    append()....
    如果添加的数据底层数组容不下就需要扩容底层数组
    默认扩容为原来容量的2倍加2同时将原有数组中的元素复制到新的数组中

    StringBuffer s2 = new StringBuffer("abc");   char[] value = new char["abc".length + 16]
    开发中建议使用StringBuffer
`

StringBuilder
    可变字符序列
    线程不安全 效率高
    jdk5新增
    底层结构使用char型数组存储
    不考虑线程安全问题 效率最高

 */
public class StringTest {
    @Test
    public void test(){
        String s1 = new String();
        String s4 = null ;
        System.out.println(s1);
        System.out.println(s4);

        StringBuffer buffer = new StringBuffer();
        System.out.println(buffer);
        StringBuffer s = new StringBuffer("abc");
        s.setCharAt(2,'d');//替换指定位置元素
        System.out.println("s = " + s);
        StringBuffer s2 = new StringBuffer("abc");
        System.out.println("s2.length() = " + s2.length());//3


    }

}
