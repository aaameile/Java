package Collection;

import org.junit.Test;

import java.util.*;
import java.util.Iterator;

/*
集合框架
     Collection接口 单列集合 用来存储一个一个的对象
        List接口 动态数组 存储有序的 可重复的数据
            ArrayList
            LinkedList
            Vector


        Set接口 存储无序的 不可重复的数据   高中讲的集合 无序 确定 互异性
           HashSet
                LinkedHashSet
           TreeSet


     Map接口 双列集合，用来存储一对（key，value）一对的数据      高中函数 y = f（x）
          HashMap
          linkedHashMap
          TreeMap
          Hashtable
          Properties

ArrayList LinkedList Vector异同
    同
        三个类都实现了List接口
        存储数据的特点一致
    不同
        ArrayList jdk1.2
            ArrayList为List主要实现类没有特殊需求不用下面2个
            线程不安全 效率高
            使用 Object[] elementData 数组存储
            jdk7
                ArrayList list = new ArrayList(); == 底层创建了长度为10的 Object[] elementData
                list.add（123） == elementData[0] = new Integer(123);
                list.add(11) 如果添加导致数组容量不够则扩容
                默认扩容为原来容量的1.5倍同时将原来数组中的数据复制到新的数组中
                实际开发中建议使用带参构造器
            jdk8
                ArrayList list = new ArrayList(); == 底层Object[] elementData 初始化为{}没有创建数组
                list.add（123） 此时才创建长度为10的数组 并将123添加到  elementData[0] = new Integer(123);中
                后续扩容与之前一样
                类似于懒汉式 延迟数组创建 节省了内存

        LinkedList jdk1.2
            使用链式存储 双向链表
            对于频繁插入、删除操作使用这个比array效率高
            LinkedList list1 = new LinkedList(); 声明了内部类 Node类型的first和last属性 默认为null
            其中Node定义为看源码

        Vector
            Vector最古老的List实现类jdk1.0
            线程安全 效率低
            使用 Object[] elementData 存储
            Vector vector = new Vector(); 底层创建了长度为10的 数组
            扩容默认为原来的2倍
List接口常用方法
    增 add
    删 remove(object obj) /(int index)
    改 set
    查 get
    遍历 Iterator 增强for循环 普通循环 因为有索引
    长度 size
 */
public class ListTest {
    @Test
    public void test(){
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        Vector vector = new Vector();
// 1
        //add
        arrayList.add(123);
        arrayList.add(456);
        arrayList.add("AA");
        arrayList.add(new User("tom",2));
        System.out.println(arrayList);
// 2
        //add(int index, Object obj)在指定位置添加元素
        arrayList.add(2,789);
        System.out.println(arrayList);
// 3
        //addAll
        List<Integer> integers = Arrays.asList(1, 2, 3);
        arrayList.addAll(integers);
        System.out.println(arrayList);
// 4
        //get(int index)获取指定位置元素
        System.out.println(arrayList.get(7));
// 5
        //indexOf(Object obj) 获取obj在集合中首次出现的索引 没有返回-1 lastIndexOf
        int i = arrayList.indexOf(3);
        System.out.println(i);
// 6
        //remove（int index）删除指定位置元素
        Object remove = arrayList.remove(7);
        System.out.println(remove);
        System.out.println(arrayList);
// 7
        //set(int index ,object o)修改指定位置元素
        arrayList.set(6,3);
        System.out.println(arrayList);
// 8
        //subList（int fromIndex，int toIndex）返回从fromIndex到toIndex位置的左闭右开区间元素
        List list = arrayList.subList(4, 5);
        System.out.println(list);
// 9
        //遍历
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        for(Object o : arrayList){
            System.out.println(o);
        }
// 10


    }
}
