package Rmi;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) throws Exception {
        //服务引入
        RmiTest rmiTest = (RmiTest) Naming.lookup("rmi://localhost:8801/rmi");
        //远程调用方法
        System.out.println(" RMI 服务器返回结果是 " + rmiTest.say("服务器"));
    }
}
