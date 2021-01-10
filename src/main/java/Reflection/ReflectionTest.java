package Reflection;

/*
反射 java.lang.Class、
    类加载过程
        程序经过javac.exe命令后 会生成一个或多个字节码文件（.class结尾）接着使用java.exe命令对某个字节码文件进行解释运行。
        相当于一个类被生成字节码文件然后使用java.exe解释运行
        此过程称为类加载
        加载到内存的类就称为运行时类 此类就作为Class的一个实例
        实际上类也是一个对象 即 Class 的对象

    运行时类
        加载到内存的运行时类会缓存一定的时间 在此时间内可以通过不同的方法获取此运行时类

    //这个实例只能有一个 java.lang.IllegalArgumentException: Test class can only have one constructor
//    @Test
//    public void test(){
//        Class<ReflectionTest> aClass = ReflectionTest.class;
//        System.out.println(aClass);
//    }
 */
public class ReflectionTest {
    private String name ;
    public int age;

    public ReflectionTest() {
    }

    public ReflectionTest(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private ReflectionTest(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ReflectionTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public void show(String nation){
        System.out.println(" 我是一个 " + nation + "人");

    }
    private void speak(){
        System.out.println(" aaaaa ");
    }

}

