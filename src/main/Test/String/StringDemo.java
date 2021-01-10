package String;

import org.junit.Test;

/*
翻转一个字符串内指定内容
 */
public class StringDemo {
    //方式一 把字符串转换为char[]
    public String Reverse(String str,int starIndex,int endIndex){
        if (str != null && str.length() != 0){
            char[] arr = str.toCharArray();
            for (int x = starIndex, y = endIndex; x < y ;x++,y--){
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
       return null;
    }

    @Test
    public void test(){
        StringDemo demo = new StringDemo();
        String s = demo.Reverse("hello",0,4);
        System.out.println(s);
    }

    //方式二 看成StringBuilder 使用StringBuilder中的方法

    //方式三 String的拼接
    public String Reverse1(String str,int starIndex,int endIndex){
        if (str != null){
            StringBuilder builder = new StringBuilder(str.length());
            builder.append(str.substring(0,starIndex));
            for (int x = endIndex; x >= starIndex; x--){
                builder.append(str.charAt(x));
            }
            builder.append(str.substring(endIndex + 1));
            return builder.toString();
        }
        return null;
    }
    @Test
    public void test2(){
        StringDemo demo = new StringDemo();
        String s = demo.Reverse1("hello",1,2);
        System.out.println(s);
    }
}
