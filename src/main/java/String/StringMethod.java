package String;

import org.junit.Test;

public class StringMethod {
    @Test
    public void test1(){
        String s = "hello world";
        System.out.println("s.length() = " + s.length());//长度
        System.out.println("s.charAt() = " + s.charAt(0));//获取指定索引值
        System.out.println("s.toLowerCase() = " + s.toLowerCase());
        System.out.println("s.toUpperCase() = " + s.toUpperCase());//大小写
        System.out.println("s.trim() = " + s.trim());//去除首尾空格
        System.out.println("s.equalsIgnoreCase(s) = " + s.equalsIgnoreCase(s));//忽略大小写的判断
        System.out.println("s.concat() = " + s.concat(s));//字符串连接相当于+
        System.out.println("s.compareTo(s) = " + s.compareTo(s));//比较字符串ascall码值 涉及到字符串排序、
        System.out.println("s.substring(2) = " + s.substring(2));//取值
        System.out.println("s.substring(0,6) = " + s.substring(0,6));
    }
    @Test
    public void test2(){
        String s = "123abc456def789hij";
        String str = s.replaceAll("\\d+",".");//把数字替换成.
        System.out.println("str = " + str);
        String stl = "137-12333212";
        boolean res = stl.matches("137-\\d{7,8}");
    }
}
