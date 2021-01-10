package Maptest;

import org.junit.Test;

import java.util.*;

/*

Map接口 双列集合，用来存储一对（key，value）一对的数据      高中函数 y = f（x）    y = x * x     x = -+x
    HashMap
        作为Map的主要实现类
        线程不安全效率高
        可以存NUll的key和value
        底层
            jdk7 数组 + 链表
            jdk8 数组 + 链表 + 红黑树

        linkedHashMap
            保证在遍历map元素时可以按照添加的顺序实现遍历
            在原有的HashMap底层结构上 重写了put方法  添加了一对指针 指向前一个和后一个元素  双向链表
            内部类为Entry、
            对于频繁的遍历操作 推荐使用

    TreeMap
        保证按照添加的key-value对进行排序 实现排序遍历 此时考虑key的自然排序 或者定制排序
        底层使用红黑树

    Hashtable
        最古老的Map实现类
        线程安全效率低
        不可以存Null的key和value

        Properties
            通常用来处理配置文件 key 和 value 都是String类型

HashMap结构理解
    Map中的key是无序的 不可重复的 可以理解为set存储所有的key   需要重写equals（） 和 HashCode（）
    Map中的value是无序的 可重复的 可以理解为Collection存储所有的value  需要重写equals（）
    一个键值对构成一个Entry数组中的元素
    Map中的entry无序的 不可重复的 可以理解为set存储所有的entry

    HashSet存的是HashMap的 key 只不过将value设置为空的Object对象

HashMap底层实现原理
    JDK7
        HashMap map = new HashMap（） 实例化后 底层创建了长度是16的一维数组Entry[] table
        ...可能已经执行过多次put再添加
        map.put(key,value)
        以HashMap为例 存储的数据在Entry数组中并非按照数组索引的顺序添加
        向HashMap中添加元素A
        首先调用元素A所在类的HashCode方法计算出A的哈希值
        A再通过某种算法计算出元素A在Entry数组存放的索引位置
        判断此位置是否已经有元素
            如果没有就添加成功
            有一个元素或者以链表形式存放的多个元素 则比较他们的哈希值
                如果哈希值不一样就以链表的形式添加成功
                哈希值相同就调用equals（）判断key返回值是否为true、
                    为true则将value1 替换为value2 就是将原本元素值替换为新添加元素的值
                    为false以链表形式存储

    JDK8相较于7在底层实现方面的不同
        new HashMap（） 底层没有创建长度为16 的数组
        第一次put（）的时候才创建长度16的数组
        8 的底层数组名为Node[] 而非 Entry[]、
        jdk7 数组 + 链表内部
        jdk8 数组 + 链表 + 红黑树
        当数组的某一个索引位置上的元素以链表形式存储超过8个 且当前数组的长度大于64时
        此时此索引上的所有数据改为使用红黑树存储

    扩容
        threshold 临界值 通过tableSizeFor（）计算出来的扩容临界值 只要达到这个值就扩容
        扩容为原来容量的2倍 并将原有数据复制过来
HashMap 和 HashTable的异同
CurrentHashMap 与 HashTable的异同

HashMapMethod

 */
public class MapTest {
    @Test
    public void test(){
        Map map = new HashMap();
// 1
        //添加 put
        map.put(null,null);
        //map = new Hashtable();
        // map.put(null,null);//java.lang.NullPointerException Hashtable()不能添加空值
// 2
        //修改 put key值一样时 此方法为修改方法
        map.put(null,123);
        System.out.println(map);
// 3
        //map.putAll（map1） 把map1添加到map里
        Map map1 = new HashMap();
        map1.put("aa",123);
        map.putAll(map1);
        System.out.println(map);
// 4
        //remove(object key)移除key的值
        map.remove("aa");
        System.out.println(map);
// 5
        //clear()
        map.clear();
        System.out.println(map.size());
        System.out.println(map);


    }
    @Test
    public void test2(){
        Map map = new HashMap();
        map.put("aa",11);
        map.put("bb",22);
// 6
        //遍历所有key keySet
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
// 7
        //遍历所有value  values（）
        Collection coll = map.values();
        for (Object o : coll){
            System.out.println(o);
        }
// 8
        //遍历所有 key value  EntrySet（）
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            //System.out.println(iterator1.next());
            Object o = iterator1.next();
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
// 9
    }



}
