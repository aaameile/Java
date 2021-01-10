package Thread;
/*
卖票
存在线程安全问题
 */
public class Window2 extends java.lang.Thread {
    private static int ticket = 10;

    //private static Object o = new Object();
    @Override
    public void run() {
        while (true) {
            //synchronized (o){
            //synchronized (Window.class){//类也是对象 class cl = window.class
            //}
            show();

        }
    }
    //private synchronized void show(){//错误解决方法因为有三个对象 synchronized
    private  synchronized void show(){//static synchronized表示当前类
        if (ticket > 0){
            System.out.println(java.lang.Thread.currentThread().getName()+"：卖票,票号为" + ticket);
            ticket--;
        }
    }
}

class WindowsTest2{
    public static void main(String[] args) {
        Window2 w = new Window2();
        Window2 w1 = new Window2();
        Window2 w2 = new Window2();
        w.setName("窗口1");
        w1.setName("窗口2");
        w2.setName("窗口3");
        w.start();
        w1.start();
        w2.start();

    }

}