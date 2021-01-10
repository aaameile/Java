package Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
/*
迭代器Iterator 只适用于Collection接口
    hasNext 判断是否还有下一个元素
    next 指向集合首位上方 指针下移  将下移后集合位置上的元素返回
    返回接口的实例 用于遍历集合元素
 */
public class Iterator {
    @Test
    public void test(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(345);
        //返回接口的实例 用于遍历集合元素
        java.util.Iterator iterator = coll.iterator();
//        System.out.println(iterator.next());下移
//        System.out.println(iterator.next());下移
        //不推荐
//        for (int i = 0; i <coll.size() ; i++) {
//            System.out.println(iterator.next());
//        }
        //判断实例中还有没有元素 有就输出
        while (iterator.hasNext()){
            System.out.println("iterator = " + iterator);
            System.out.println(iterator.next());
        }
    }


}
