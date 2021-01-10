package Reflection;

import org.junit.Test;
/*
getFields（）获取当前运行时类及其父类中声明为pubic访问权限的属性
getDeclaredFields 获取当前运行时类所有不包含父类属性属性

 */
public class User {
    @Test
    public void test() throws ClassNotFoundException {
        //方式一 调用  运行时类的属性.class  User.class
        Class<User> userClass = User.class;
        System.out.println(userClass);//class Reflection.User

        //方式二 通过运行时类的对象
        User user = new User();
        Class<? extends User> aClass = user.getClass();
        System.out.println(aClass);

        //方式3 调用Class的静态方法 forName(String classPath)
        Class<?> aClass1 = Class.forName("Reflection.User");
        Class<?> aClass2 = Class.forName("java.lang.Object");
        System.out.println(aClass1);
        System.out.println(aClass2);

        //方法4类的加载器 ClassLoader
        ClassLoader classLoader = User.class.getClassLoader();
        Class<?> aClass3 = classLoader.loadClass("Reflection.User");
        System.out.println(aClass3);

    }
    //通过反射方式创建对象
    //要想通过这种方法创建对象
    // 运行时类必须提供空参构造器
    // 空参构造器的访问权限不能小
    @Test
    public void test2() throws IllegalAccessException, InstantiationException {
        Class<User> userClass = User.class;
        //newInstance(); 调用此方法创建对应的运行时类对象
        User user = userClass.newInstance();
        System.out.println(user);
    }

}

