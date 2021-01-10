package Thread;
/*
多线程的创建
    继承于thread
        创造一个继承thread的子类
        重写thread类的run方法
        创建thread类的子类的对象
        通过此对象调用start（）
        start
            启动当前线程
            调用当前线程的run（）
Thread.currentThread().getName()获取线程的名字
Thread.currentThread()当前线程
线程生命周期
    新建
    就绪
    运行
    阻塞
        发生阻塞的方式
            sleep
            join
            等待同步锁
            wait
            suspend
        阻塞结束的方式
            sleep时间到
            join结束
            获取同步锁
            notify/notifyAll
            resume
    死亡
例遍历100以内所有偶数

 */

class Thread extends java.lang.Thread {
    @Override
    public void run() {
        for (int i = 0;i < 100;i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() +";"+ i);
            }
        }
    }
}
class ThreadTest{
    public static void main(String[] args) {
        Thread thread = new Thread();
        Thread thread1 = new Thread();
        thread.start();//执行当前线程的run（）

        //thread.start();//不能启动已经启动的线程再启动就会抛异常
        thread1.start();//需要重新创建一个对象开启线程
        //thread.run();//只是同一个线程 对象调方法
        //以下操作仍然在main线程中执行
        for (int i = 0;i < 100;i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + "Thread");
            }
        }


    }
}
















