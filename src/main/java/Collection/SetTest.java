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
HashSet
    Set的主要实现类
    线程不安全
    可以存储Null值

LinkedHashSet
    HashSet的子类遍历其内部数据是可以按照添加的顺序遍历
    作为HashSet的子类在添加数据时每个数据还维护了2个引用 记录此数据前一个数据和后一个数据
    对于频繁的遍历操作效率高一些


TreeSet
    可以按照添加的对象指定属性 进行排序
    向TreeSet中添加的数据要求是相同类的对象

set
    set接口中没有额外定义新的方法 使用的都是Collection中声明的方法

    以HashSet为例 存储的数据在底层数组中并非按照数组索引的顺序添加
    向HashSet中添加元素A
    首先调用元素A所在类的HashCode方法计算出A的哈希值  如果元素所在类没有重写hashcode 调用的是object的hashcode 返回的是地址
    A再通过某种算法计算出元素A在HashSet底层数组存放的索引位置
    判断此位置是否已经有元素
        如果没有就添加成功
        有元素或者以链表形式存放的多个元素 则比较二者哈希值
            如果哈希值不一样就添加成功以链表的形式
            哈希值一致就调用equals（）判断返回值是否为true、
                为true则添加失败
                为false以链表形式存储
    7上8下链式存储
    HashSet 底层 链表加数组存储结构

    无序性
        不等于随机性  添加数据的时候
        以HashSet为例 存储的数据在底层数组中并非按照数组索引的顺序添加
        而是根据数据的哈希值存储

    不可重复性
        保证添加的元素按照equals（）判断时 不能返回true  相同的元素不能存在2个
        根据哈希值判断是否有相同元素

自定义对象存储
    List
        需要重写equals
    Set
        以HashSet LinkedHashSet为例需要重写equals HashCode
        treeSet 需要重写Comparable Comparator
 */
public class SetTest {
    //无序性 根据数据的哈希值存储
    @Test
    public void test(){
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add("abc");
        set.add(new User("jerry",12));
        set.add(129);
        set.add(129);
        LinkedHashSet<Object> objects = new LinkedHashSet<>();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(set);
    }
    //HashSet不可重复性
    @Test
    public void test2(){
        Set set = new HashSet();
        Cat c = new Cat("tom1",13);
        set.add(c);
        set.add(new Cat("tom",16));
        set.add(new Cat("tom",12));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
        c.setName("tom2");
        set.remove(c);//没有移除掉 因为哈希值不同 此时的哈希值是按照名字为tom2的名字计算的 所以和tom1 有极大概率不同
        Iterator iterator2 = set.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }

    //TreeSet ClassCastException 不能添加不同类型的对象
    // 存储的数据是从小到大排序的
    // 如果是自定义类型 需要指定排序方法 自然排序Comparable 或者 定制排序 Comparator

    @Test
    public void test3(){
        Set set =  new TreeSet();
//        set.add(123);
//        set.add("123");
//        System.out.println(set);
//        set.add(13);
//        set.add(2);
//        set.add(54);
        set.add(new Cat("tom",1));
        set.add(new Cat("tom1",21));
        set.add(new Cat("tom2",13));
        set.add(new Cat("tom3",21));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    //定制排序 使用带参TreeSet构造器 默认使用自然排序
    @Test
    public void test4(){
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Cat && o2 instanceof Cat){
                    Cat c = (Cat) o1;
                    Cat c1 = (Cat) o2;
                    return Integer.compare(c.getAge(),c1.getAge());

                }else {
                    throw  new RuntimeException("输入的数据类型不匹配");
                }

            }
        };
        TreeSet set = new TreeSet(com);
        set.add(new Cat("tom",1));
        set.add(new Cat("tom1",21));
        set.add(new Cat("tom2",13));
        set.add(new Cat("tom3",21));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }




}
class Cat implements Comparable{
    private String name;
    private int age;

    public Cat() {
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;

        Cat cat = (Cat) o;

        if (age != cat.age) return false;
        return Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        //result = 31 * result + age;
        result = ((result << 5 )- 1) + age;//31为素数 素数乘以一个数结果只能被素数本身和这个数 和 1 整除 减少冲突
        // 哈希值越大查找起来效率也会提高
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Cat){
            Cat cat = (Cat) o;
            //return this.name.compareTo(cat.name);
            int compare = this.name.compareTo(cat.name);
            if (compare != 0){
                return compare;
            }else {
                return Integer.compare(this.age,cat.age);
            }
        }else {
            throw new RuntimeException("输入类型不匹配");
        }
    }
}