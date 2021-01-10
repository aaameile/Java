package Thread;
/*
创建2个分线程遍历100以内偶数另一个线程遍历100以内奇数

 */
class Test{
    public static void main(String[] args) {
        Thread t = new Thread();
        t.start();
        Thread2 t2 = new Thread2();
        t2.start();
        //创建匿名子类

    }

}
public class Thread extends java.lang.Thread {
    @Override
    public void run() {
        for (int i = 0;i < 100;i++){
            if (i % 2 == 0){
                System.out.println(java.lang.Thread.currentThread().getName() + ":" + i + "- thread");
            }
        }
    }
}
class Thread2 extends java.lang.Thread{
    @Override
    public void run() {
        for (int i = 0;i < 100;i++){
            if (i % 2 != 0){
                System.out.println(java.lang.Thread.currentThread().getName() + ":" + i + "- thread2");
            }
        }
    }
}