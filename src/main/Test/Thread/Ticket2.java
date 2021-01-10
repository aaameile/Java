package Thread;
/*
方式二:同步方法
    如果操作共享数据的代码完全声明在一个方法中我们可以将此方法声明为同步的
同步
    解决了线程安全问题
    但是操作同步代码时只有一个线程参与，其他线程等待相当于是一个单线程的过程 效率低------局限性

 */
public class Ticket2 implements Runnable{
    private int ticket = 30;
    //Object o = new Object();
    @Override
    public  void run() {
        while (true){
            show();
            }
    }
    private synchronized void show(){//锁就是this
        if (ticket > 0){
            try {
                java.lang.Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(java.lang.Thread.currentThread().getName() +"：卖票,票号为" + ticket);
            ticket--;
        }
    }
}

class ticketTest2{
    public static void main(String[] args) {
         Ticket2 ticket = new Ticket2();

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