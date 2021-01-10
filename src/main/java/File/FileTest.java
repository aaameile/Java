package File;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/*
file类的使用
    file类的一个对象 代表一个文件或一个目录 俗称文件夹

相对路径
    相较于某个路径下指明的路径
    junit 相较于当前model下
    main  相较于当前Project下

绝对路径
    包含盘符在内的文件或文件目录的路径
路径分隔符
    windows \\
    unix /
 */
public class FileTest {
    //构造器一 创建文件
    @Test
    public void test(){
        File file = new File("jdbc.properties");//相对于当前module
        File file2 = new File("D:\\workspace.idea\\javaSenior\\File\\jdbc.properties");//绝对路径 双\\因为java\是换行
        System.out.println(file);//此时还不考虑有没有文件

      //构造器二 创建文件夹
        File f3 = new File("D:\\workspace","jvm");//在D盘workspace文件夹下创建一个jvm文件夹

      //构造器三 在f3文件夹下创建文件
      File f4 = new File(f3,"hi.txt");
        System.out.println(f4);
    }
    //常用方法
    @Test
    public void test2(){
        File file = new File("Hello.txt");
        File file2 = new File("D:\\workspace.idea\\javaSenior\\File\\jdbc.properties");

        System.out.println(file.getAbsoluteFile());//获取绝对路径
        System.out.println(file.getPath());//获取路径
        System.out.println(file.getName());//名字
        System.out.println(file.getParent());//文件目lu
        System.out.println(file.lastModified());//最近修改时间
        System.out.println(file.length());//长度

        System.out.println();

        System.out.println(file2.getAbsoluteFile());//获取绝对路径
        System.out.println(file2.getPath());//获取路径
        System.out.println(file2.getName());//名字
        System.out.println(file2.getParent());//文件目lu
        System.out.println(file2.lastModified());//最近修改时间
        System.out.println(file2.length());//长度
    }
    //显示文件目录
    @Test
    public void test3(){
        File file = new File("C:\\workspace.idea");
        String[] list = file.list();
        assert list != null;
        for (String s : list){
            System.out.println(s);
        }

        File[] files = file.listFiles();
        assert files != null;
        for (File f : files){
            System.out.println(f);
        }

    }

    //重命名到指定的文件路径
    @Test
    public void test4(){
        File file = new File("hello.txt");
        System.out.println(file.getAbsoluteFile());
        File file2 = new File("C:\\workspace.idea\\hi.txt");
        boolean b = file.renameTo(file2);
        System.out.println(b);
    }


    //
    @Test
    public void test5(){
        File file = new File("C:\\workspace.idea\\hi.txt");
        System.out.println(file.isDirectory());//是否是文件目录
        System.out.println(file.isFile());;
        System.out.println(file.exists());//是否存在
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());//是否隐藏

        System.out.println();

        File file2 = new File("C:\\workspace.idea");
        System.out.println(file2.isDirectory());//是否是文件目录
        System.out.println(file2.isFile());;
        System.out.println(file2.exists());//是否存在
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());//是否隐藏
    }

    //创建真实的文件
    @Test
    public void test6() throws IOException {
        File file = new File("hello.txt");
        if (!file.exists()){
           file.createNewFile();
            System.out.println(" 创建成功 ");
        }else {
            file.delete();
            System.out.println(" 删除成功 ");
        }

    }
    //创建目录
    @Test
    public void test7(){
        File file = new File("C:\\file\\file1");
        boolean mkdir = file.mkdir();//创建目录没有上一层就不会创建
        if (mkdir){
            System.out.println(" 创建成功1 ");
        }

        File file2 = new File("C:\\file\\file1");
        boolean mkdirs = file.mkdirs();//没有上层目录会一并创建
        if (mkdirs){
            System.out.println(" 创建成功2 ");
        }
    }

}
