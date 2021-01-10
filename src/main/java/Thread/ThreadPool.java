package Thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/*
线程池
    好处
        提高响应速度 减少线程创建时间
        降低资源消耗
        便于线程管理
            setCorePoolSize 核心池的大小
            maximumPoolSize 最大线程数
            keepAliveTime 线程没有任务时最多保持多长时间后会终止

 */
class NumThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(java.lang.Thread.currentThread().getName() + "-" + i);
            }
        }
    }
}
class NumThread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0){
                System.out.println(java.lang.Thread.currentThread().getName() + "-" + i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //1 提供指定数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        //设置线程属性
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        service1.setCorePoolSize(10);
        //2 执行指定的线程操作 需要提供实现Runnable接口或者Callable接口实现类的对象
        service.execute(new NumThread());//适用于Runnable
        service.execute(new NumThread2());//适用于Runnable
        //service.submit(Callable callable);//适用于Callable

        //3 关闭连接池
        service.shutdown();
    }
}
