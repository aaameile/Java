package Collection;

import org.junit.Test;

import java.util.*;

/*
集合框架概述
    集合和数组都是对多个数据进行存储操作的结构 简称java容器
    此时的存储主要指的是内存层面的存储不涉及到持久化的存储 比如（txt。jpg。avi。数据库）

    数组存储数据的特点
        一旦初始化后实际长度就确定了 元素类型也就确定了
    数组缺点
        一旦初始化后长度就不可修改
        数组中提供的方法有限 对于crud操作非常不便
        获取数组中实际元素个数的需求 数组没有现成的属性或方法可用
        存储数据特点是有序的 可重复的 对于无序 不可重复的需求不能满足

集合框架
     Collection接口 单列集合 用来存储一个一个的对象
        List接口 动态数组 存储有序的 可重复的数据
            ArrayList
            LinkedList
            Vector


        Set接口 存储无序的 不可重复的数据   高中讲的集合 无序 确定 互异性
           HashSet
           LinkedHashMap
           TreeSet


     Map接口 双列集合，用来存储一对（key，value）一对的数据      高中函数 y = f（x）
          HashMap
          linkedHashMap
          TreeMap
          Hashtable
          Properties

Collection接口中的方法


 */
public class CollectionTest {
    @Test
    public void test(){
        Collection coll = new ArrayList();
// 1
        //add（）将元素e添加到coll集合中
        coll.add("aa");
        coll.add('a');
        coll.add(123);//自动装箱
        coll.add(456);
        coll.add(new Date());
// 2
        //size()获取添加的元素的个数
        System.out.println(coll.size());

// 3
        //addAll （Collection coll）将coll集合中的元素添加到coll1的集合中 add方法只能添加对象
        Collection coll1 = new ArrayList();
        coll1.add("asd");
        coll1.addAll(coll);
        System.out.println(coll1.size());
        System.out.println(coll1);
// 4
        //clear()清空集合元素
        coll.clear();
// 5
        //isEmpty（）判断当前集合是否有元素
        System.out.println(coll.isEmpty());
// 6
        //contains 判断当前集合中是否包含当前obj
        // 实际上是调用equals（）
        coll.add(new String("tom"));
        System.out.println(coll.contains(new String("tom")));
// 7
        //contains 判断自定义类的对象
        // 需要手动重写equals（）
        // 因为ArrayList是顺序存储所以在调用equals时会从第一个数据开始比较 直到找到要比较的对象才不会往下继续查找
        coll.add(new User("tom",12));
        System.out.println(coll.contains(new User("tom", 12)));
// 8
        //coll.containsAll(coll2) 判断当前集合中是否包含coll2中所有元素 相当于集合的包含
        Collection coll2 = Arrays.asList("tom");//Arrays.asList等于 new ArrayList . add
        System.out.println(coll.containsAll(coll2));
// 9
        //remove 从当前集合中移除某个元素 成功返回true 依然是调用equals比较查找是否相等再删除        差 集
        coll.remove("tom");
        System.out.println(coll);
// 10
        //removeAll 从当前集合中移除另外一个集合中他们共有的元素 成功返回true
        Collection coll3 = Arrays.asList(new User("tom", 12));
        System.out.println(coll.removeAll(coll3));
        System.out.println(coll);
// 11
        //交集 求coll 与 coll4的交集
        coll.add(123);
        Collection coll4 = Arrays.asList(123,456);
        coll.retainAll(coll4);
        System.out.println(coll);
// 12
        //equals 比较的是2个集合存储的数据   顺序也要一致
        coll.add(456);
        Collection coll5 = Arrays.asList(456,123);
        System.out.println(coll.equals(coll5));
// 13
        //hashCode 返回哈希值
        System.out.println(coll.hashCode());
// 14
        //集合---》数组 toArray
        Object[] arr = coll.toArray();
        for (Object o : arr) {
            System.out.println(o);
        }
// 15
        //数组----》集合调用Arrays的静态方法asList
        List<String> strings = Arrays.asList(new String[]{"a", "b", "c"});
        System.out.println(strings);
        List<int[]> ints = Arrays.asList(new int[]{12, 22});//返回的是地址不会自动装箱
        System.out.println(ints);
        System.out.println(ints.size());
        List<Integer> list = Arrays.asList(new Integer[]{123, 32});//需要用包装类
        System.out.println(list.size());
// 16
        //返回接口的实例 用于遍历集合元素
    }






}
class User{
    String name;
    Double age;
    public User(){

    }
    public User(String name,double age){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return age != null ? age.equals(user.age) : user.age == null;
    }
//
//    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + (age != null ? age.hashCode() : 0);
//        return result;
//    }
}