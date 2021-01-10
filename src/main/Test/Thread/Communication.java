package Thread;

/*
线程通信
    使用两个线程打印1-100 线程1 线程2 交替打印
wait() 线程进入阻塞状态并释放同步监视器
notify() 唤醒被wait() 的一个线程如果有多个线程被wait() 就唤醒优先级高的那个
notifyAll() 唤醒所有被wait()的线程

说明
    线程通信方法必须只能出现在同步代码块 或者 同步方法中
    调用者必须是同步代码块 同步方法 中的同步监视器 的同一对象

sleep（） wait（）
    相同点
        都使线程进入阻塞状态
    不同点
    声明位置不同 thread类中声明sleep object类中声明wait
    调用要求不同 sleep可以再任何场景使用 wait只能在同步代码块中使用
    关于是否释放锁 sleep不会释放 wait会释放

 */
class Number implements Runnable{
    private int num = 1;

    @Override
    public void run() {
        while (true){
            //notifyAll();三个以上
            synchronized (this) {
                notify();//唤醒线程 省略this  调用者必须是同步代码块中的同一个锁
                if (num <= 100){
                    System.out.println(java.lang.Thread.currentThread().getName() + "——" + num);
                    num++;
                    try {
                        //使得调用wait的线程进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }

        }
    }
}
public class Communication {
    public static void main(String[] args) {
        Number n = new Number();
        java.lang.Thread t = new java.lang.Thread(n);
        java.lang.Thread t2 = new java.lang.Thread(n);
        t.setName("线程1");
        t2.setName("线程2");
        t.start();
        t2.start();
    }
}
