package InteAddress;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
实现TCP的网络编程
    先进行三次握手四次挥手
    可靠的数据传输
    可以大量传输数据
    效率低

 */
public class TCP {
    //客户端
    @Test
    public void client(){
        Socket socket = null;
        OutputStream stream = null;
        try {
            //创建Socked 对象 指明服务器端的ip和端口号
            InetAddress address = InetAddress.getByName("127.0.0.1");
            socket = new Socket(address,8899);
            //获取一个输出流  输出数据
            stream = socket.getOutputStream();
            //输出数据
            stream.write("你好客户端".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //资源关闭
                assert socket != null;
                socket.close();
                assert stream != null;
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    //服务器
    @Test
    public void sever(){
        ServerSocket ss = null;
        InputStream stream = null;
        ByteArrayOutputStream baos = null;
        Socket accept = null;
        try {
            //创建服务器端SeverSocket 指明服务器端口号 （此处为本机端口号）
            ss = new ServerSocket(8899);

            //接收来自客户端的Socket
            accept = ss.accept();

            //获取输入流 接收数据
            stream = accept.getInputStream();

            //读取输入流中接收的数据
            baos = new ByteArrayOutputStream();
            byte[] buff = new byte[10];
            int count;
            while ((count = stream.read(buff)) != -1){
                baos.write(buff,0,count);
            }
            System.out.println(baos.toString());
            System.out.println("收到来自" + accept.getInetAddress().getHostAddress() + "的数据");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭资源
                assert baos != null;
                baos.close();
                stream.close();
                ss.close();
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
