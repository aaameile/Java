package IO;

import org.junit.Test;

import java.io.*;

/*
缓冲流 处理流之一
    字节流
    BufferInputStream
    BufferOutputStream
作用
    提供流的读取 写入的速度
    套接在已有流的身上就是处理流

 */
public class BufferStream {
    @Test
    public void test(){
        FileInputStream inputStream;
        FileOutputStream outputStream;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File("1.png");
            File destFile = new File("3.png");
            //解密只需要将文件反向传输 异或操作再异或操作等于原来
            //File srcFile = new File("3.png");
            //File destFile = new File("1.png");
            inputStream = new FileInputStream(srcFile);
            outputStream = new FileOutputStream(destFile);
            bis = new BufferedInputStream(inputStream);
            bos = new BufferedOutputStream(outputStream);
            byte[] buff = new byte[20];
            int count;
            while ((count = bis.read(buff)) != -1){
                //加密 不能用加强for
                for (int i = 0; i < count; i++) {
                    buff[i] = (byte)(buff[i] ^ 5);
                }
                bos.write(buff,0,count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //外层流关闭内层流也会关闭
            try {
                assert bis != null;
                bis.close();
                assert bos != null;
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
                //bos.flush();刷新缓冲区一般都是自动刷新
        }
    }
    //bufferRead
    @Test
    public void test2(){
        FileReader read;
        FileWriter writer;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            File srcFile = new File("world.txt");
            File destFile = new File("world.txt");
            read = new FileReader(srcFile);
            writer = new FileWriter(destFile);
            br = new BufferedReader(read);
            bw = new BufferedWriter(writer);
            //方法一
//            char[] buff = new char[10];
//            int count;
//            while ((count = bis.read(buff)) != -1){
//                bos.write(buff,0,count);
//            }
            //方法二 readLine()一次读一行
            String data;
            while ((data = br.readLine())!= null){
                //方法1
                //bw.write(data + "\n");//data中不包含换行符
                //方法二
                bw.write(data);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //外层流关闭内层流也会关闭
            try {
                assert br != null;
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert bw != null;
                bw.close();
                //bos.flush();刷新缓冲区一般都是自动刷新
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test3(){
        File file = new File("student.txt");
        String[] content ={"天气预报","北京晴天","上海多云","有小雨","大连晴","有时多云"};
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        try {
            writer = new FileWriter(file);
            bufferedWriter = new BufferedWriter(writer);
            for (String src : content){
                bufferedWriter.write(src);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
//                assert writer != null;
//                writer.close();
                assert bufferedWriter != null;
                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println(" 读取出错 " + e);
            }
        }

    }
}
