package IO;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
io流
实际上开发中用的是apache.commons.jar包中的FileUtils工具类
    分类
    按照数据单位 字节流 字符流
    数据流向 输入 输出流
    流的角色 节点流 处理流

    体系结构
        抽象基类                          节点流或者文件流                  处理流（缓冲流）
        字节流
        InputStream                       FileInputStream                BufferInputStream
        OutputStream                      FileOutputStream               BufferOutputStream

        字符流
        Reader                            FileReader                     BufferReader
        Writer                            FileWriter                     BufferWriter

    read（）返回读入的一个字符 如果达到文件末尾返回-1
    为了保证流资源可以正常关闭需要使用try catch
    读入文件一定要存在否则就会报异常
    不能用字符流处理字节流    图片



 */
public class IOTest {
    public static void main(String[] args) {
        File file = new File("hello.txt");//相较于当前工程
        System.out.println(file.getAbsolutePath());
        File file1 = new File("javaSenior\\hello.txt");
        System.out.println(file1.getAbsolutePath());
    }

    //读取内容并输出
    @Test
    public void test() {
        FileReader fileReader = null;
        try {
            File file = new File("hello.txt");
            System.out.println(file.getAbsolutePath());//相较于当前module
            fileReader = new FileReader(file);
            int read;
//        while (read != -1){
////            System.out.println((char) read);
////            read = fileReader.read();
////        }
            while ((read = fileReader.read()) != -1){
                System.out.println(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流关闭
            try {
                assert fileReader != null;
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    //read（char[] crr）
    @Test
    public void test2(){
        FileReader fileReader = null;
        try {
            File file = new File("hello.txt");
            //System.out.println(file.getAbsolutePath());//相较于当前module
            fileReader = new FileReader(file);
            char[] cbuff = new char[1024];
            int read;
//        while (read != -1){
////            System.out.println((char) read);
////            read = fileReader.read();
////        }
            while ((read = fileReader.read(cbuff)) != -1){
                for (int i = 0;i < read;i++){
                    System.out.println(cbuff[i]);
                }
//                String str = new String(cbuff,0,read);
//                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流关闭
            try {
                assert fileReader != null;
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //从内存写入数据到硬盘文件
    //文件不存在不会报异常
    // 如果 对应的文件不存在 会自动创建此文件
    // 如果 文件存在 调用写入构造器是FileWriter(file,false) FileWriter(file) 会对文件覆盖
    // 调用写入构造器是FileWriter(file，true) 不会对文件覆盖 而是在原有基础上往后面添加
    @Test
    public void test3(){
        FileWriter writer = null;
        try {
            File file = new File("world.txt");
            writer = new FileWriter(file,false);
            writer.write("面对疾风吧\n");
            writer.write("哈撒给");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert writer != null;
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //读取写入 相当于复制文件内容到另一个文件
    @Test
    public void test4(){
        FileReader reader = null;
        FileWriter writer = null;
        try {
            File file = new File("world.txt");
            File file1 = new File("world2.txt");
            reader = new FileReader(file);
            writer = new FileWriter(file1);
            char[] cbc = new char[5];
            int count;
            while ((count = reader.read(cbc)) != -1){
                writer.write(cbc,0,count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert writer != null;
                writer.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
