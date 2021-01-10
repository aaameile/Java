package IO;

import org.junit.Test;

import java.io.*;

/*
转换流 处理流之一
    属于字符流
    InputStreamReader 字节输入流转换为字符输入流   解码

    OutputStreamWriter 字符输出流转换为字节输出流  编码

    解码  字节 字节数组---》字符字符数组
    编码  字符 字符数组---》字节 字节数组

    字符集

 */
public class InputRead {
    @Test
   public void test() throws IOException {
        FileInputStream fis = new FileInputStream("world.txt");
        //InputStreamReader reader = new InputStreamReader(fis);//系统默认的编码格式
        InputStreamReader reader2 = new InputStreamReader(fis,"utf-8");//按照指定的编码格式解码
        char[] ch = new char[20];
        int count;
        while ((count = reader2.read(ch)) != -1){
            String s = new String(ch, 0, count);
            System.out.println(s);
        }
        reader2.close();
    }
    @Test
    public void test2() throws IOException {
        FileOutputStream fis = new FileOutputStream("world.txt");
        OutputStreamWriter os = new OutputStreamWriter(fis,"gbk");
        //系统默认的编码格式
        //按照指定的编码格式解码
        System.out.println(os);
    }
}
