package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
线程创建方法3 实现callable接口 ---- jdk5.0新增
比实现runnable强大
    call有返回值
    call可以抛出异常
    call有返回值支持泛型
 */
public class New implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <100 ; i++) {
            if (i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
class newThread{
    public static void main(String[] args) {
        New n = new New();
        FutureTask f = new FutureTask(n);
        java.lang.Thread t = new java.lang.Thread(f);
        t.start();
        try {
            //get方法返回值 为FutureTask 构造器参数Callable实现类重写call的返回值
            Object sum = f.get();
            System.out.println("sum = " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
