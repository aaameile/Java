package Collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Collections 操作Collection 和 Map 的工具类

Collections 和 Collection 区别

 */
public class CollectionsTest {
    @Test
    public void test(){
        List list = new ArrayList();
        list.add(123);
        list.add(321);
        list.add(123);
        list.add(456);
        System.out.println(list);
// 1
        //reverse 反转 List 元素
        Collections.reverse(list);
        System.out.println(list);
// 2
        //shuffle 对list集合元素随机排序
        Collections.shuffle(list);
        System.out.println(list);
// 3
        //sort根据自然顺序对指定的List按升序排序
        Collections.sort(list);
        System.out.println(list);

// 4
        //sort(List,Comparator) 根据指定Comparator产生的顺序对List进行排序
        //Collections.sort(list, Comparator);
// 5
        //swap（list，int，int）将指定list集合中的i处元素和j处元素进行交换
        Collections.swap(list,3,2);
        System.out.println(list);
// 6
        //int frequency(Collection,object) 返回指定集合中指定元素出现的次数
        int frequency = Collections.frequency(list, 123);
        System.out.println(frequency);
// 7
        //线程安全的list  list1即为线程安全的
        List list1 = Collections.synchronizedList(list);


// 8
// 9
// 10
    }

    //java.lang.IndexOutOfBoundsException: Source does not fit in dest
    // copy 复制一个数组 要求是desc 长度要大于 list长度 否则报错

    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(123);
        list.add(321);
        list.add(123);
        list.add(456);
        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(dest);
    }

}
