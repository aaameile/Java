package Rmi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer {
    public static void main(String[] args) {
        int port = 1314;
        final ExecutorService service = Executors.newFixedThreadPool(2 * Runtime.getRuntime().availableProcessors());
        try {
            ServerSocket socket = new ServerSocket(port);
            System.out.println("socket.getLocalSocketAddress() = " + socket.getLocalSocketAddress());
            while (true){
                Socket accept = socket.accept();
                System.out.println("accept.getRemoteSocketAddress() = " + accept.getRemoteSocketAddress());
                service.execute(new ClientHandler(accept));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }
}
