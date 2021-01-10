package Thread;
/*
thread常用方法
star()启动当前线程调用当前线程的run（）
run()通常重写thread类的此方法 蒋创建的线程要执行的操作写在方法内
currentThread（）静态方法返回执行当前代码的线程
getName（）获取线程名字
setName（）设置当前线程名字
yield()在某个条件下释放当前cpu的执行权 让cpu去执行下一个线程 也有可能下一次又执行这个线程
join()在线程a中调用线程b的join 此时线程a就进入阻塞状态直到b执行完a才结束阻塞状态
stop（）已过时 执行此方法时强制结束线程
sleep（）让当前线程睡眠指定的毫秒数 在指定时间内线程为阻塞状态
isAlive（）

线程优先级
    MAX_PRIORITY 10
    MIN_PRIORITY 1
    NORM_PRIORITY 5
设置线程优先级
    setPriority(int new Priority)
    getPriority
说明
    高优先级的线程要抢占低优先级线程cpu的执行权 但是只从概率上来说
     高优先级的线程高概率的情况下被执行并不意味着只有当高优先级的线程执行完以后第优先级的线程才执行
 */

class thread3 extends java.lang.Thread{
    @Override
    public void run() {
        for (int i = 0;i < 100;i++){
            if (i % 2 == 0){
//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(java.lang.Thread.currentThread().getName() + ":" + i + "-" + getPriority());
            }
//            if (i % 20 == 0){
//                yield();//释放当前cpu执行权
//                意思就是当前线程被cpu执行调用此方法之后就不执行这个线程了
//                去执行下一个线程也有可能下一次又执行这个线程
//            }
        }
    }
    public thread3(String name){
        super(name);
    }
    public thread3(){}


}
public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
       // thread3 t3 = new thread3("thread3");//通过构造器给线程命名
        thread3 thread3 = new thread3();
        //thread3.setPriority(java.lang.Thread.MAX_PRIORITY);//优先执行的几率比较高
        thread3.setName("线程1");
        thread3.start();
        //t3.start();
        //给主线程设置名字
        java.lang.Thread.currentThread().setName("主线程");
        //java.lang.Thread.currentThread().setPriority(java.lang.Thread.MIN_PRIORITY);
        for (int i = 0;i < 100;i++){
            if (i % 2 == 0){
                System.out.println(java.lang.Thread.currentThread().getName() + ":" + i );
            }
            if(i == 20){
                thread3.join();//当i = 20 的时候运行thread3线程
            }
        }
        System.out.println( thread3.isAlive());//判断这个线程是否存活

    }
}
