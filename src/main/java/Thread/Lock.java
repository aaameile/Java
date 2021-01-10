package Thread;

import java.util.concurrent.locks.ReentrantLock;


/*
解决线程安全问题的方法
锁 jdk 5新增
ReentrantLock 和 synchronized
    相同
        都能解决线程安全问题
    不同
        synchronized 执行完相应的同步代码以后自动释放同步监视器
        ReentrantLock  手动启动同步 lock（） 结束也需要手动  unlock（）
 */
class Windows implements Runnable{
    private int ticket = 10;
    //实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock(true);//true先进先出公平锁
    @Override
    public void run() {
        while (true){
            try {
                //调用lock方法
                lock.lock();
                if (ticket > 0){
                    try {
                        java.lang.Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("售票口" + java.lang.Thread.currentThread()
                            .getName() + "票号为" + ticket );
                    ticket--;
                }else {
                    break;
                }
            } finally {
                //调用解锁方法
                lock.unlock();
            }
        }
    }
}
public class Lock {
    public static void main(String[] args) {
        Windows w = new Windows();
        java.lang.Thread t = new java.lang.Thread(w);
        java.lang.Thread t2 = new java.lang.Thread(w);
        java.lang.Thread t3 = new java.lang.Thread(w);
        t.setName("1");
        t2.setName("2");
        t3.setName("3");
        t.start();
        t2.start();
        t3.start();

    }
}

