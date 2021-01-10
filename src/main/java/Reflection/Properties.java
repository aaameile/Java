package Reflection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/*
加载配置文件
 */
public class Properties {
    @Test
    public void test() throws IOException {
        //读取方式1
       FileInputStream stream = new FileInputStream("jdbc.properties");
//        pros.load(stream);
        java.util.Properties  pros = new java.util.Properties();

        //方式二
        ClassLoader loader = Properties.class.getClassLoader();
        InputStream is = loader.getResourceAsStream("jdbc.properties");//文件需要在resources下
        pros.load(is);


        String user = pros.getProperty("user");
        System.out.println(user);
    }
}
