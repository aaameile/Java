package Generic;


import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;
//自定义泛型类 类的内部结构就可以使用泛型

//异常类不能为泛型

public class User<T> {
    String userName;
    int userId;
    T userT;

    public User(String userName, int userId, T userT) {
        this.userName = userName;
        this.userId = userId;
        this.userT = userT;
    }

    public User() {
        T[] arr = (T[]) new Object[12];
    }

    public T getUserT() {
        return userT;
    }

    public void setUserT(T userT) {
        this.userT = userT;
    }
    //静态方法不能使用类的泛型
//    public static void show(){
//        System.out.println("userT = " + userT);
//    }
}

class UserTest extends User<Integer>{
    public void test() {
        User user = new User();
        //user.setUserT(123);
        user.setUserT("232");

    }
    public void test1() {
        User<String> user = new User<>();
        //user.setUserT(123);
        user.setUserT("232");
        UserTest.test3(new User[1]);
    }
    //在方法中出现了泛型的结构 泛型参数与类的泛型参数没有任何关系
    //不确定方法中方放什么结构就用泛型方法 public <E> List<E> test3(E[] arr)
    public static  <E> List<E> test3(@NotNull E[] arr){
        ArrayList<E> list = new ArrayList<>();
        //Collections.addAll(list, arr);
        for (E e : arr){
            list.add(e);
        }
        return list;
    }


}
