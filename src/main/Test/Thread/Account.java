package Thread;

public class Account {
    private double balance;
    public Account(){}

    public Account(double balance) {
        this.balance = balance;
    }
    //存钱
    public synchronized void deposit(double amt){
        if (amt > 0){
            balance += amt;
            try {
                java.lang.Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(java.lang.Thread.currentThread().getName() + " 存款成功！您的余额为：" + balance);
        }
    }
}

class Customer extends java.lang.Thread {
    private Account account;
    public Customer(Account account){
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }
}
class AccountTest{
    public static void main(String[] args) {
        Account a = new Account();
        Customer c = new Customer(a);
        Customer c1 = new Customer(a);
        c.setName("小红");
        c1.setName("小敏");
        c.start();
        c1.start();




    }
}
