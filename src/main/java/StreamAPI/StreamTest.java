package StreamAPI;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
Stream
    对数据的运算 与cpu有关
    集合是数据的存储 与内存有关

    不会改变原对象 相反会返回一个持有结果的Stream
    操作是延迟执行的意味着是要等到需要结果的时候才执行
    一个中间操作链 对数据源的数据进行处理
    一旦终止操作就执行中间操作链 并产生结构 之后不会再被使用

终止操作
     *  查找与匹配
     *  allMatch --检查是否匹配所有元素
     *  anyMatch --检查是否至少匹配一个元素
     *  noneMatch --检查是否没有匹配所有元素
     *  findFirst -- 返回第一个元素
     *  findAny -- 返回流中的任意一个元素
     *  count -- 返回流中的总个数
     *  max -- 返回流中最大值
     *
 */
public class StreamTest {
    //方式1 集合
    @Test
    public void test(){
        List<User> users = User.getUsers();
        Stream<User> userStream = users.stream();//返回一个顺序流
        Stream<User> parallelStream = users.parallelStream();//返回一个并行流

        //筛选与切片
        // 查询 找出年龄大于12的人
        userStream.filter(user -> user.getAge() > 12).limit(2).forEach(System.out::println);

        //limit 截断流不显示第二个元素后面的元素 每次操作需要重新生成一个流users.stream()
        users.stream().limit(5).forEach(System.out::println);
        System.out.println();

        // skip跳过元素  跳过前几个元素
        users.stream().skip(3).forEach(System.out::println);
        System.out.println();

        // distinct 筛选 去重 通过流的hashCode 和 equals去除重复元素
        users.stream().distinct().forEach(System.out::println);
        System.out.println();

    }
    //方法2 数组
    public void test2(){
        int[] arr = new int[]{1,23,5,1,2,4,3,1,};
        IntStream stream = Arrays.stream(arr);//返回一个流

        User user = new User("sa",2);
        User user2 = new User("sa",2);
        User[] users = new User[]{user,user2};
        Stream<User> stream1 = Arrays.stream(users);//泛型
    }

    //方法3 Stream本身
    public void test3(){
        Stream<Integer> stream = Stream.of(2,41,4,5,31,2);
    }

    //方法4 创建无限流
    public void test4(){
        Stream.iterate(0,t -> t + 2).limit(10).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

//映射 中间操作
    // map(fun f） 接收一个函数作为参数将元素转换成其他形式或提取信息
    // 该函数会被应用到每个元素上 并将其映射成一个新的元素
    @Test
    public void test5(){
        //转换成大写
        List<String> list = Arrays.asList("a", "b", "c", "d");
        list.stream().map(String::toUpperCase).forEach(System.out::print);
        System.out.println();

        //返回名字长度大于1的
        List<User> users = User.getUsers();
        Stream<User> userStream = users.stream();//返回一个顺序流
        Stream<String> stream = userStream.map(User :: getName);
        userStream.filter(user -> user.getName().length() > 1 ).forEach(System.out::print);
        System.out.println();
        //stream.filter(name -> name.length() > 1).forEach(System.out::print);

    }

    //flatMap(fun f)
    // 接收一个函数作为参数，将流中每个值都换成另外一个流 然后把所有流连接成一个流   相当于addAll
    //相当于list.add   添加数组A到数组B 数组B中包含数组A 有2个数组
    // 和 list.allAll  添加数组A到数组B 数组A中元素都用数组B装成一个数组


//中间操作 之 排序
    //sorted    自然排序
    @Test
    public void test7(){
        List<Integer> list = Arrays.asList(1, 43, 5, 2, 3, 5, 3, 1, 5, 6);
        list.stream().sorted().forEach(System.out::println);
        System.out.println();
        //定制排序 sorted
        List<User> users = User.getUsers();
        users.stream().sorted(Comparator.comparingInt(User::getAge)).forEach(System.out::println);
        //users.stream().sorted((users1,users2) -> Integer.compare(users1.getAge(),users2.getAge()))
        // .forEach(System.out::println);

    }

/*    终止操作
     *  查找与匹配
     *  allMatch --检查是否匹配所有元素
     *  anyMatch --检查是否至少匹配一个元素
     *  noneMatch --检查是否没有匹配所有元素
     *  findFirst -- 返回第一个元素
     *  findAny -- 返回流中的任意一个元素
     *  count -- 返回流中的总个数
     *  max -- 返回流中最大值
     * forEach 遍历 内部迭代
 */
    @Test
    public void test8(){
        List<User> users = User.getUsers();

        //检查  是否没有存在姓小的人
        boolean b = users.stream().allMatch(user -> user.getName().startsWith("小"));
        System.out.println(b);

        //匹配 找任意一个人
        Optional<User> any = users.parallelStream().findAny();
        System.out.println(any);
        //年龄最大的人
        Optional<Integer> max = users.stream().map(User::getAge).max(Integer::compare);
        System.out.println(max);

    }
/*
归约
     *  reduce （T identity，BinaryOperation） / reduce （BinaryOperation） ----可以将流中元素反复结合起来 得到新值
 */
     @Test
    public void test9(){
        //求和
        List<Integer> list = Arrays.asList(1, 3, 5, 6, 3, 8, 9, 5);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}
