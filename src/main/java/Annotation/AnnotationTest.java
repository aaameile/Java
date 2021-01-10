package Annotation;

/*
Annotation 注解 代码里的特殊标记
    文档注解

    jdk三个基本注解
        Override
            限定重写父类方法 该注解只用于方法
        Deprecated
            表示所修饰的元素（类 方法 ）已过时 或存在更好的选择
        SuppressWarnings  如何自定义注解可以参照此注解的写法
            抑制编译期警告

    框架注解

    自定义注解
        SuppressWarnings  如何自定义注解可以参照此注解的写法
        注解声明为接口
        内部成员定义通常用value表示  多个可以用数组表示
        可以指定成员的默认值  使用default定义
        如果没有成员 表明是一个标识作用
        使用注解时需要指定注解的值
        自定义注解必须配上注解的信息处理流程（反射）才有意义
        通常指明2个元注解 Target Retention

    元注解 元数据 对现有数据的修饰  String name = “cctv” 此时Sting name 就称为元数据
        对现有的注解修饰的注解就是元注解
        Retention
            指定所修饰的注解的声明周期 SOURCE CLASS(默认) RUNTIME  只有声明为Runtime为生命周期的注解才能通过反射获取
        Target
            指明注解在哪些地方可用 （TYPE FIELD METHOD PARAMETER CONSTRUCTOR LOCAL_VARIABLE）
                                 (类    文件  方法    形参      构造器       属性)

        Documented
            表示所修饰的注解在被javadoc解析时保留下来 默认是不保留
        Inherited
            别它修饰的注解具有继承性 意思就是使用了加了Inherited的注解的类 在被继承的时候子类相当于使用了注解

    通过反射获取注解信息。。。
        Retention生命周期需要是Runtime

jkd8新特性
    可重复注解
        @Repeatable(注解名.class)
        注解名的@target 和 @Retention 需要与声明可重复注解相同

    类型注解
        TYPE_PARAMETER 写在类型变量的声明语句中如  泛型声明
        TYPE_USE 表示该注解可以写在使用类型的任何语句中


 */
//@MyAnnotation(value = "hello")//自定义注解

import java.util.ArrayList;

@MyAnnotation
public class AnnotationTest {
}

class TYPE_PARAMETER<@MyAnnotation T>{//类型注解 相当于这个注解可以修饰泛型
    public void show (){
        ArrayList<@MyAnnotation String>  list= new ArrayList<>();
        int mun = (int) 10L;
    }
}
