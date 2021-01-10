package InteAddress;

/*
URL网络编程
    URL 统一资源定位符
    格式
        通信协议 主机名 端口号 资源地址 文件名 ？ 参数列表
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL; 

public class Url {

    public static void main(String[] args) {

        HttpURLConnection connection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("http://localhost:8080/examples/2.jpg");
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            is = connection.getInputStream();
            fos = new FileOutputStream("2.jpg");
            byte[] buff = new byte[1024];
            int count;
            while ((count = is.read(buff)) != -1) {
                fos.write(buff, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                assert fos != null;
                fos.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            connection.disconnect();
        }

//            url.getProtocol();//获取主机名
//            url.getHost();//端口号
//            url.getPort();//
//            url.getPath();//文件路径
//            url.getFile();//文件名
//            url.getQuery()//查询名



    }
}
