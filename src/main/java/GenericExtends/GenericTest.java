package GenericExtends;

import java.util.*;

/*
泛型继承体现
    虽然Object 是 String的父类 但是 List<Object> 和 List<String> 不具备子父类关系
通配符的使用
 */
public class GenericTest {
    public void test(){
        Object obj = null;
        String str = null;
        obj = str;
        str = (String) obj;

        Object[] obj1 = null;
        String[] str1 = null;
        obj = str;
        str1 = (String[]) obj1;
// 1
        //此时他俩不具备子父类关系
        // 虽然Object 是 String的父类 但是 List<Object> 和 List<String> 不具备子父类关系

        List<Object> list = null;
        List<String> list1 = null;
        //list = list1;
        list = Collections.singletonList(list1);

        show(list);
        //show(list1);


        //相反 AbstractList 是 List的父类  List<Object> 和 List<String> 具备子父类关系
        ArrayList<String> s = null;
        List<String> s1 = null;
        AbstractList<String> s2 = null;
        //s = s1;
        s2 = s;


    }
    //证明 虽然Object 是 String的父类 但是 List<Object> 和 List<String> 不具备子父类关系
    public void show(List<Object> list){}

// 2
    //通配符的使用 ?
    //虽然Object 是 String的父类 但是 List<Object> 和 List<String> 不具备子父类关系
    //List<?> 是 List<Object> 和 List<String> 的公共父类
    public void show2(List<Object> list){

    }
    public void show3(List<String> list){

    }
    public void test4(){
        List<Object> list = null;
        List<String> list1 = null;
        List<?> list2 ;
        list2 = list;
        list2 = list1;

        print(list);
        print(list1);

        //list2.add("23"); 加了通配符就不能添加数据了
        // 除了添加null
        //能读取 但不能写入 读取的数据类型为Object
        Object o = list2.get(1);
    }
    public void print(List<?> list){
        for (Object o : list) {
            System.out.println(o);
        }

    }

// 3
    //有限制条件的通配符  把 ? 看做是 [负无穷大，正无穷大]
    // ? extends A       [-无穷大 ~ A] 能读取 读取的返回值为 等于A或者A的父类 能写入A的父类
    // ? super A         [A ~ +无穷大] 能读取 读取的返回值为 等于A或者A的子类 能写入A的子类和它本身类
    // ? extends A   类型？小于等于A类型    赋值只能赋给它本身和他的子类
    // ? super A     类型A大于等于？类型    赋值只能赋给它本身和他的父类
    public void test3(){
        List<? extends String> list = null;
        List<? super String> list1 = null;
    }

}
