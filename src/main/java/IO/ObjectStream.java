package IO;

import org.junit.Test;

import java.io.*;

/*
对象流
    ObjectInputStream
    ObjectOutputStream
    用于存储和读取基本数据类型数据或对象的处理流 将内存中的java对象保存到磁盘中数据库中

    可序列化的要求
        自定义对象需要实现接口 implements Serializable
        在类中声明全局常量   * private static final long serialVersionUID = 42L;
        类中属性也需要是序列化的 默认基本数据类型是课序列化的

    不能序列化 static 和 transient修饰的成员
 */
public class ObjectStream implements Serializable{
    //序列化 将内存中java、对象保存到磁盘中或通过网络传输出去
    // ObjectOutputStream
    @Test
    public void test(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Object.txt"));
            oos.writeObject(new String("nikezhenshigexiaojilingui"));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert oos != null;
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //反序列化 将磁盘文件还原为java对象
    // ObjectInputStream
    @Test
    public void test2(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Object.txt"));
            Object o = ois.readObject();
            String str = (String) o;
            System.out.println(str);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                assert ois != null;
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
