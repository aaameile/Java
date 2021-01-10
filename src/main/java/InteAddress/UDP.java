package InteAddress;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/*
UDP网络编程
    不可靠
    以数据报形式发送数据报限定为64kb 效率高

 */
public class UDP {
    //发送端
    @Test
    public void send() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        String str = "UDP";
        byte[] data = str.getBytes();
        InetAddress localHost = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, localHost, 9888);
        socket.send(packet);
        socket.close();
    }
    //接收端
    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9888);
        byte[] buff = new byte[100];
        DatagramPacket packet = new DatagramPacket(buff,0,buff.length);
        socket.receive(packet);
        String s = new String(packet.getData(),0,packet.getLength());
        System.out.println(s);
    }

}
