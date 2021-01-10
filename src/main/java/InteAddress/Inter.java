package InteAddress;

import org.junit.Test;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*
网络编程
    如何准确的定位网络上一台或多台主机 定位主机上特定的应用
    找到主机后如何可靠高效的进行数据传输
网络编程2个要素
    IP 和 端口号  InetAddress
        IP 分类 ipv4 ipv6 万维网 局域网
            唯一的标识 Internet 上的计算机（通信实体）
            在java中使用InetAddress类代表IP
            域名
                www.baidu.com
                本地回路地址 127.0.0.1 本机地址
                对应着localhost

        端口号 要求不同的进程有不同的端口号
            一个16位的整数0~65535

        IP端口号组合在一起叫 Socket

实例化 getByName   getLocalHost
getHostName 获取域名
getHostAddress 主机地址 IP地址

提供网络通信协议  TCP/IP参考模型 应用层  传输层  网络层   物理 + 数据链路层
传输层  网络层
TCP     IP
 */
public class Inter {
    @Test
    public void test(){
        InetAddress name = null;
        InetAddress name2 = null;
        InetAddress name3 = null;
        try {
            name = InetAddress.getByName("192.168.01.11");
            name2 = InetAddress.getByName("www.baidu.com");
            name3 = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(name);
        System.out.println(name2);
        System.out.println(name3);

    }

}
