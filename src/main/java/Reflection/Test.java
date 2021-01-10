package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    @org.junit.Test
    public void test(){
        ReflectionTest reflectionTest = new ReflectionTest("sda",12);
        reflectionTest.setAge(13);
        System.out.println(reflectionTest.toString());
        reflectionTest.show("中国");

    }

    @org.junit.Test
    public void test2() throws Exception {
        Class rtc = ReflectionTest.class;
        Constructor constructor = rtc.getConstructor(String.class, int.class);
        Object o = constructor.newInstance("aaa", 14);
        ReflectionTest r = (ReflectionTest) o;
        r.show("中国");
        System.out.println(r.toString());
        Field age = rtc.getDeclaredField("age");
        age.set(r,10);
        System.out.println(r.toString());
        //Method speak = rtc.getDeclaredMethod("speak");
        //speak.invoke(r);

        //通过反射可以调用私有结构
        Constructor cons1 = rtc.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        ReflectionTest r2 = (ReflectionTest) cons1.newInstance("tom");
        System.out.println(r2.toString());

        //
        Method speak = rtc.getDeclaredMethod("speak");
        speak.setAccessible(true);
        speak.invoke(r2);


    }
}
