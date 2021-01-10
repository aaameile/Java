package Lambda;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/*
lambda表达式  (o1,o2) -> Integer.compare(o1,o2);
    -> lambda 操作符 箭头操作符
    ->左边 lambda形参列表 其实就是接口中的形参列表
    ->右边 lambda体 重写抽象方法的方法体
    本质就是作为函数式接口的实例

需要依赖于函数式接口
    函数式接口
        接口只声明了一个抽象方法

java内置四大核心函数式接口
    消费型 Consumer<T> void accept(T t)
    供给型 Supplier<T> T get()
    函数型 Function<T,R> R apply(T t)
    断定型 Predicate<T>  boolean test(T t)

方法引用   类（对象） :: 方法名  当要传递给Lambda体的操作 已经有实现的方法 就可以使用方法引用
    本质上就是Lambda表达式 而Lambda 表达式作为函数式接口的实例 所有方法引用 也是函数式接口的实例
    s -> System.out.println(s); == System.out::println
    Consumer 中的void accept(T t) 和 PrintStream中的 void println（T t）

    具体分为三种
        对象 :: 非静态方法
        类 :: 静态方法  Integer::compare
        类 :: 非静态方法
方法引用要求
    接口中的抽象方法的形参列表和返回值类型与方法引用的形参列表和返回值相同


写法 6 种


 */
public class LambdaTest {
// 1
    //无参 无返回值
    @Test
    public void test() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(" woain  ");
            }
        };
        r.run();

        Runnable r2 = () -> System.out.println(" casd ");
        r2.run();
    }

// 2
    //2个以上参数 多条执行语句 可以有返回值
    @Test
    public void test2(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int compare = com.compare(23, 90);
        System.out.println(compare);

        //lambda
        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);
        System.out.println(com2.compare(3,2));

        //方法引用
        Comparator<Integer> com3 = Integer::compare;
            int compare2 = com3.compare(23, 90);
            System.out.println(compare2);

    }

// 3
    //有一个参数 无返回值
    @Test
    public void test3() {
//        Consumer<String> con = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };
//        con.accept("你好");

        //lambda

        Consumer<String> con1 = s -> System.out.println(s);
        con1.accept("见到你很高兴");

        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("你好");
    }

// 4
    ////有一个参数 无返回值 小括号可省

// 5
    //类型自动推断

// 6
    //Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);
    // 方法体只有一条语句 可以省略大括号 return


public static void main(String args[]){
    Thread thread = new Thread(() -> pnog());
    thread.run();
    System.out.println(" ping ");
    List<String> a = null;
    System.out.println(a.size());
}
public static void pnog(){
    System.out.println(" pong ");
}
}
