package Thread;

class Clerk{//店员
    private int productCount = 0;
    public synchronized void produceProduct(){
        if (productCount < 20){
            productCount++;
            System.out.println(java.lang.Thread.currentThread().getName() + "开始生产产品" + productCount);
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };//生产产品

    public synchronized void consumProduct() {
        if (productCount > 0){
            System.out.println(java.lang.Thread.currentThread().getName() + "开始消费产品 " + productCount);
            productCount--;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }//销售产品

}
public class Product extends java.lang.Thread {
    private Clerk clerk;
    public Product(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        System.out.println(java.lang.Thread.currentThread().getName() + "开始生产产品");
        while (true){

            clerk.produceProduct();
        }

    }//生产者

}
class Consumer extends java.lang.Thread {
    private Clerk clerk;
    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        System.out.println(" 开始销售 ");
        while (true){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumProduct();
        }
    }//消费者

}
class ProductTest{
    public static void main(String[] args) {
        Clerk c = new Clerk();
        Product p = new Product(c);

        p.setName("生产者");
        Consumer con = new Consumer(c);
        con.setName("消费者");
        p.start();
        con.start();

    }
}

