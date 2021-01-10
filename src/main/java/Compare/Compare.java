package Compare;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/*
java中比较对象一般使用 ==  ！= 不能使用 < , > 但是在开发中需要对对象进行排序就需要对对象进行比较大小
所以使用 Comparable 或 Comparator 接口
    Comparable 自然排序
        String类， 包装类等实现了Comparable接口 重写了compareTo(obj)方法给出了比较两个对象的方法 默认从小到大排序
        重写compareTo(obj)规则
             如果当前对象大于形参对象时返回正整数
             如果当前对象小于形参对象时返回负整数
             如果当前对象等于形参对象时返回零
        对于自定义类
             排序需要实现Comparable接口，自己重写compareTo(obj)方法指明如何排序
             叫做自然排序

    Comparator 定制排序
        当元素的类型没有实现Comparable接口而且又不方便改代码
        或者实现了接口的排序规则不适合当前操作
        那么可以考虑使用Comparator的对象来排序

        重写compare(obj o1,obj 02)方法 比较哦o1 ，o2 大小 规则
             如果方法返回正数则表示o1 大于 o2
             如果方法返回正数则表示o1 小于 o2
             如果方法返回正数则表示o1 等于 o2

对比
    Comparable 自然排序
        不能改变的比较
    Comparator 定制排序
        临时比较
 */

public class Compare {
    //自然排序
    @Test
    public void test(){

        String[] srr = new String[]{"S","A","D","E","Q","W","R"};
        Arrays.sort(srr);
        System.out.println(Arrays.toString(srr));
    }

    @Test
    public void goodTest(){
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("lenvov",90);
        goods[1] = new Goods("dell",79);
        goods[2] = new Goods("mi",89);
        goods[3] = new Goods("huawei",99);
        Arrays.sort(goods);//比较大小
        System.out.println(Arrays.toString(goods));
    }

    //定制排序  默认从小到大排序  大写字母视为小
    @Test
    public void test2(){
        String[] srr = new String[]{"f","G","D","E","c","b","a"};    //默认[D, E, G, a, b, c, f]
        Arrays.sort(srr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);   //[f, c, b, a, G, E, D]
                }
                throw new RuntimeException("输入类型数据不一致");
            }
        });
        System.out.println(Arrays.toString(srr));
    }

    //按照名称从小到大    按照价格从高到低
    @Test
    public void test3(){
        Goods[] goods = new Goods[5];
        goods[0] = new Goods("lenvov",90);
        goods[1] = new Goods("dell",79);
        goods[2] = new Goods("mi",89);
        goods[3] = new Goods("huawei",99);
        goods[4] = new Goods("huawei",19);
        Arrays.sort(goods, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                if (o1 != null && o2 != null){
                    if (o1.getName().equals(o2.getName())){
                        return -Double.compare(o1.getPrice(),o2.getPrice());
                    }else {
                        return o1.getName().compareTo(o2.getName());
                    }
                }
                throw new RuntimeException("输入数据类型不一致");
            }
        });//比较大小
        System.out.println(Arrays.toString(goods));
    }

}
//货物类
class Goods implements Comparable{
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //自然排序 按照价格从低到高 按照名称从大到小
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else {
                return -this.name.compareTo(goods.name);//从大到小
            }
            //return Double.compare(this.price, goods.price);
        }
            throw new RuntimeException("传入的数据类型不一致");
    }
}