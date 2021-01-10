package Thread;
/*
创建多线程方法2
    实现runnable接口的类
    实现类去实现runnable中的抽象方法 run（）
    创建类的对象
    将此对象作为参数传递到thread类的构造器中创建thread类的对象
    通过thread类的对象调用star（）
开发中优先选择这种方式
    原因没有类的单继承的局限性
    实现更适合多个线程有共享数据
联系
    两种方式都需要实现run方法
    将线程要执行的逻辑声明在run中
 */
public class Thread3 implements Runnable {
    @Override
    public void run() {
        for (int i = 0;i < 100;i++){
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }


}
class thread2Test{
    public static void main(String[] args) {
        //Thread2 t2 = new Thread2();
        java.lang.Thread t = new java.lang.Thread(new Thread3());//Thread构造器是带参的  参数是Runnable 类型的target
        t.start();//启动线程  调用当前线程的run 此时的run是经过处理的  调用的是Runnable类型的 target的run

        

    }
}