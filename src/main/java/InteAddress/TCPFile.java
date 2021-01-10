package InteAddress;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
客户端发送文件到服务器保存到本地  服务器再给客户端反馈
 */
public class TCPFile {
    //客户端
    @Test
    public void client(){
        Socket socket = null;
        OutputStream stream = null;
        FileInputStream fis = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        try {
            //创建Socked 对象 指明服务器端的ip和端口号
            InetAddress address = InetAddress.getByName("127.0.0.1");
            socket = new Socket(address,9000);
            //获取一个输出流  输出数据
            stream = socket.getOutputStream();

            fis = new FileInputStream("3.png");
            //输出数据
            byte[] buff = new byte[1024];
            int count;
            while ((count = fis.read(buff)) != -1){
                stream.write(buff,0,count);
            }

            //接收反馈之前关闭数据的输出不然没有明确指示服务器不知道传没传完
            socket.shutdownOutput();

            System.out.println(" =--- ");
            //接收反馈
            inputStream = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            //byte[] buff2 = new byte[20];
            int count2;
            while ((count2 = inputStream.read(buff)) != -1){
                baos.write(buff,0,count2);
            }
            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //资源关闭
                assert fis != null;
                assert baos != null;
                baos.close();
                inputStream.close();
                fis.close();
                socket.close();
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
        FileOutputStream fos = null;
        Socket accept = null;
        OutputStream os = null;
        try {
            //创建服务器端SeverSocket 指明服务器端口号 （此处为本机端口号）
            ss = new ServerSocket(9000);

            //接收来自客户端的Socket
            accept = ss.accept();

            //获取输入流 接收数据
            stream = accept.getInputStream();

            fos = new FileOutputStream("6.png");

            //读取输入流中接收的数据
            byte[] buff = new byte[1024];
            int count;
            while ((count = stream.read(buff)) != -1){
                fos.write(buff,0,count);
            }

            //反馈信息
            os = accept.getOutputStream();
            os.write("图片已收到".getBytes());

           // System.out.println(os.toString());
            System.out.println("收到来自" + accept.getInetAddress().getHostAddress() + "的数据");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭资源
                assert fos != null;
                fos.close();
                stream.close();
                ss.close();
                accept.close();
                assert os != null;
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
