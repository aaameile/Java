package StringBufferAndStringBuder;

import org.junit.Test;

/*
StringBuffer常用方法
    增 append
    删 delete
    改 setCharAt  replace
    查 charAt
    插 insert
    遍历 toString
    长度 length


 */
public class StringBufferMethod {
    @Test
    public void test(){
        StringBuffer s = new StringBuffer("abc");
        s.append(1);
        s.append("1");//添加一个元素
        System.out.println(s);

        s.delete(0,1);//删除指定位置元素 左闭右开
        System.out.println(s);

        s.replace(2,4,"hello");//左闭右开 把指定位置元素替换为指定字符串
        System.out.println(s);

        s.insert(7," world");//在指定位置添加一个字符串
        System.out.println(s.length() + "---" + s);


    }
    @Test
    public void test2(){
        StringBuffer s2 = new StringBuffer("dlrow olleh");
        s2.reverse();//翻转
        System.out.println(s2);

        int a = s2.indexOf("o",1);
        System.out.println(a);

        String str = s2.substring(0,5);//返回一个指定位置左闭右开的新字符串
        System.out.println(str);

    }
}
