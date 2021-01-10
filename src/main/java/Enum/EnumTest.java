package Enum;

/*
枚举类
    类的对象只有有限个 确定的‘
    当需要定义一组常量时 建议使用枚举类
    如果枚举类只有一个对象 那就是单例模式的实现方式
定义
    jkd5之前自定义枚举类

    jdk5之后使用enum关键字定义枚举类 定义的枚举类继承于java。lang。enum
    输出需要重写toString（）
    enum常用方法
        valueOf  查找对象
        values   找总共有哪些对象
        toString

    实现接口的情况

 */
public class EnumTest {
    public static void main(String[] args) {
        Season season = Season.SPRING;
        System.out.println(season);
        //enum定义
        Season1 season1 = Season1.SPRING;

        //toString 输出的是对象
        System.out.println(season1);

        //values()生成一个数组 存的是对象SPRING SUMMER AUTUMN WINTER 找总共有哪些对象
        Season1[] s = Season1.values();
        for (Season1 value : s) {
            System.out.println(value);
        }
        //thread内部类State也是枚举类
        Thread.State[] ts = Thread.State.values();
        for (Thread.State value : ts){
            System.out.println("value = " + value);
        }

        //valueOf 返回枚举类中对象名是objName 的对象 查找对象
        //Season1 season11 = Season1.valueOf("spring");如果写错没找到就会抛异常
        Season1 season11 = Season1.valueOf("SPRING");
        System.out.println(season11);

        //实现接口 在enum类中实现抽象方法 可以让枚举类的对象分别实现接口中方法达到各自不同的功能
        season1.Show();
        Season1.SPRING.Show();


    }

}
interface Info{
    void Show();
        }


//自定义枚举类
class Season{
    private final String NAME;
    private final String DESC;

    private Season(String NAME, String DESC) {
        this.NAME = NAME;
        this.DESC = DESC;
    }

    public static final Season SPRING = new Season("春","春暖花开");
    public static final Season SUMMER = new Season("夏","夏日炎炎");
    public static final Season AUTUMN = new Season("秋","秋高气爽");
    public static final Season WINTER = new Season("冬","冰天雪地");


    @Override
    public String toString() {
        return "Season{" +
                "NAME='" + NAME + '\'' +
                ", DESC='" + DESC + '\'' +
                '}';
    }
}


enum Season2 {

}

//enum定义枚举类  代码相同部分省略 不用写属性
enum  Season1 implements Info{
    //多个对象之间用逗号末尾对分号结束
    SPRING ("春","春暖花开"){
        @Override
        public void Show() {
            System.out.println(" 春天在哪里 ");;
        }
    },
    SUMMER ("夏","夏日炎炎"){
        @Override
        public void Show() {
            System.out.println(" 宁夏 ");
        }
    },
    AUTUMN ("秋","秋高气爽"),
    WINTER ("冬","冰天雪地");

    private Season1(String NAME, String DESC) {
    }

    @Override
    public void Show() {
        System.out.println(" 这是一个季节 ");
    }
}