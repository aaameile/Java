package Thread;
/*
出现重票 错票 出现了线程的安全问题
原因
    某个线程操作车票过程中 尚未操作完成其他线程也参与进来 也操作车票
解决
    当一个线程在操作时 其他线程不能参与进来直到这个进程操作完成其他线程才能进来
    这种情况即使线程出现阻塞也不能被改变
在java中我们通过同步机制来解决线程安全问题
    方式一：同步代码块
        synchronized（同步监视器）{
        需要被同步的代码
        }

        操作共享数据的代码即为需要被同步的代码
        共享数据：多个线程共同操作的变量
        同步监视器：俗称 锁 任何一个类的对象
            要求多个线程必须要共用一把锁 Object o = new Object();
            可以考虑使用this当锁
            在继承当中慎用 可以考虑使用当前类 class cl = window.class

    方式二:同步方法
        如果操作共享数据的代码完全声明在一个方法中我们可以将此方法声明为同步的
同步
    解决了线程安全问题
    但是操作同步代码时只有一个线程参与，其他线程等待相当于是一个单线程的过程 效率低------局限性

 */
public class Ticket implements Runnable{
    private int ticket = 30;
    //Object o = new Object();
    @Override
    public void run() {
        while (true){
            synchronized (this){//synchronized(o){ 此时this代表唯一对象
                if (ticket > 0){
                    try {
                        java.lang.Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(java.lang.Thread.currentThread().getName() +"：卖票,票号为" + ticket);
                    ticket--;
                }else {
                    break;
                }
            }

        }
    }
}
class ticketTest{
    public static void main(String[] args) {
         Ticket ticket = new Ticket();

        java.lang.Thread t = new java.lang.Thread(ticket);
        java.lang.Thread t2 = new java.lang.Thread(ticket);
        java.lang.Thread t3= new java.lang.Thread(ticket);
        t.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t.start();
        t2.start();;
        t3.start();
    }
}