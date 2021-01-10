package IO;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
字节流
    文本文件用字符流（txt java c c++）
    非文本文件用字节流（jpg mp3 mp4 avi doc ppt）
    FileInputStream
    FileOutputStream

    实际上可以用字符流对任何文件进行复制
 */
public class FileInPutOutPut {
    //字节流读取文本文件会乱码 中文是占三个字节
    @Test
    public void test(){
        FileInputStream inputStream = null;
        try {
            File file = new File("world.txt");
            inputStream = new FileInputStream(file);
            byte[] buff = new byte[6];
            int count;
            while ((count = inputStream.read(buff)) != -1){
                String s = new String(buff, 0, count);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert inputStream != null;
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
    //实现图片的复制
    @Test
    public void test2(){
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            File srcFile = new File("1.png");
            File destFile = new File("7.png");

            inputStream = new FileInputStream(srcFile);
            outputStream = new FileOutputStream(destFile);
            byte[] buff = new byte[5];
            int count;
            while ((count = inputStream.read(buff)) != -1){
                outputStream.write(buff,0,count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert inputStream != null;
                inputStream.close();
                assert outputStream != null;
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void test4(String srcPath,String destPath){
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            inputStream = new FileInputStream(srcFile);
            outputStream = new FileOutputStream(destFile);
            byte[] buff = new byte[1024];
            int count;
            while ((count = inputStream.read(buff)) != -1){
                outputStream.write(buff,0,count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert inputStream != null;
                inputStream.close();
                assert outputStream != null;
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //复制一个视频
    @Test
    public void test5(){
        long star = System.currentTimeMillis();
        String srcPath ="C:\\Users\\Apple\\Desktop\\1548651764c0b8e9536a3ad921.mp4_last.mp4";
        String destPath = "C:\\Users\\Apple\\Desktop\\1548651764c0b8e9536a3ad9212.mp4_last.mp4";
        test4(srcPath,destPath);
        long end = System.currentTimeMillis();
        long time = end - star;
        System.out.println(time);
    }

    @Test
    public void test3(){
//        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
//            File srcFile = new File("1.png");
//            File destFile = new File("2.png");

//            inputStream = new FileInputStream(srcFile);
            outputStream = new FileOutputStream("hello.txt");
            byte[] buff = "您好，近来忙嘛".getBytes();
            int count;
           outputStream.write(buff);
//            while (count = ){
//                outputStream.write(buff,0,count);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
//                assert inputStream != null;
//                inputStream.close();
                assert outputStream != null;
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
