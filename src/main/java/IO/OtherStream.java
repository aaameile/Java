package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
其他流的使用
    标准输入输出流
    打印流
    数据流
 */
public class OtherStream {
    //标准输入输出流
    // System.in  标准输入流 默认从键盘输入
    // System.out 标准输出流 默认从控制台输出 SetIn SetOut

    @lombok.SneakyThrows
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            reader = new BufferedReader(isr);
            while (true){
                System.out.println(" 请输入字符串 ");
                String s = reader.readLine();
                if ("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)){
                    System.out.println(" 程序结束 ");
                    break;
                }
                String s1 = s.toUpperCase();
                System.out.println(s1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert reader != null;
            reader.close();
        }

    }

}
