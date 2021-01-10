package Thread;
/*
卖票
存在线程安全问题
 */
public class Window extends java.lang.Thread {
    private static int ticket = 10;
    private static Object o = new Object();
    @Override
    public void run() {
        while (true){
            //synchronized (o){
            synchronized (Window.class){//类也是对象 class cl = window.class
                if (ticket > 0){
                    System.out.println(getName()+"：卖票,票号为" + ticket);
                    ticket--;
                }else {
                    break;
                }
            }

        }

    }
}
class WindowsTest{
    public static void main(String[] args) {
        Window w = new Window();
        Window w1 = new Window();
        Window w2 = new Window();
        w.setName("窗口1");
        w1.setName("窗口2");
        w2.setName("窗口3");
        w.start();
        w1.start();
        w2.start();

    }

}