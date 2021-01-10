package Generic;

import org.junit.Test;

import java.util.*;

/*
泛型 JDK5 新增特性
自定义泛型
    泛型类
    泛型接口
    泛型方法
    见user.java


 */
public class GenericTest {
    //不使用泛型
    @Test
    public void test(){
        ArrayList list = new ArrayList();
        list.add(90);
        list.add(96);
        list.add(94);
        list.add(92);
        //list.add("80");//类型不安全
        for (Object score : list){
            int score1 = (Integer) score;//类型转换出异常
            //java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
            System.out.println(score1);
        }
    }
    //使用泛型
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(90);
        list.add(90);
        list.add(90);
        list.add(90);
        //编译时进行类型检查 保证数据类型安全
        //list.add("da");编译过不了
        for (Integer score : list){
            int c = score;//避免强转
            System.out.println(c);
        }
    }
    //HashMap使用泛型
    @Test
    public void test3(){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("tom",12);
        map.put("tom1",12);
        map.put("tom2",12);
        map.put("tom3",12);
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
//        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String, Integer> next = iterator.next();
//            String key = next.getKey();
//            Integer value = next.getValue();
//        }
        for (Map.Entry<String, Integer> next : entrySet) {
            String key = next.getKey();
            Integer value = next.getValue();
        }

    }
}
