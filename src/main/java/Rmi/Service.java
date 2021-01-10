package Rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;

public class Service {
    public static void main(String[] args) throws Exception {
//        //创建服务
//        RmiImpl rmi = new RmiImpl();
//        //注册服务
//        LocateRegistry.createRegistry(8801);
//
//        Naming.bind("rmi://localhost:8801/rmi",rmi);
//        System.out.println(" 服务器开启成功");
//
        LocateRegistry.createRegistry(8801);
        RMISocketFactory.setSocketFactory(new CustomerSocketFactory());
        RmiImpl rmi1 = new RmiImpl();
        Naming.bind("rmi://localhost:8801/rmi",rmi1);
        System.out.println(" 服务器开启成功2");
    }
}
