package Maptest;

import java.io.FileInputStream;
import java.io.IOException;

/*
Map
Hashtable子类作为古老的实现类 线程安全效率低 不能存储null的key和value
子类 通常用来处理配置文件 key和value都是String类型
 */
public class Properties {
    public static void main(String[] args){

        FileInputStream fis = null;//只找得到工作区间下的配置文件
        try {
            java.util.Properties properties = new java.util.Properties();
            fis = new FileInputStream("jdbc.properties");
            properties.load(fis);//加载
            String name = properties.getProperty("name");
            String pwd = properties.getProperty("pwd");
            System.out.println(name);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
