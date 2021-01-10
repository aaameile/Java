package Rmi;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class ClientHandler implements Runnable{
    //储存所有注册的客户端
    private static final Map<String, Socket> SOCKET_MAP = new ConcurrentHashMap<>();
    private final Socket client;
    private String name;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        //获取客户端输入流
        try {
            InputStream inputStream = client.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            while (true){
                String i = String.valueOf(scanner.nextInt());

                if (i.startsWith("register:")){
                    String[] split = i.split(":");
                    if (split.length == 2 && split[0].equals("register")){
                        String s = split[1];
                        register(s);
                    }
                    continue;
                }

                if (i.startsWith("groupChat:")){
                    String[] split2 = i.split(":");
                    if (split2.length == 2 && split2[0].equals("groupChat")){
                        String s = split2[1];
                        gropChat(s);
                    }
                    continue;
                }

                if (i.startsWith("privateChat:")){
                    String[] split3 = i.split(":");
                    if (split3.length == 3 && split3[0].equals("privateChat")){
                        String s = split3[1];
                        String s1 = split3[2];
                        privateChat(s,s1);
                    }
                    continue;
                }
                if (i.equals("bye")){
                    quitChat();
                    break;
                }
            }//while
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    private void gropChat(String s) {
    }

    private void privateChat(String s, String s1) {
    }

    private void quitChat() {
    }

    private void register(String s) {
    }
}//run
