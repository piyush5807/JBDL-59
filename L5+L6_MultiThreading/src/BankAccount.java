public class BankAccount{

    private String name;
    private Integer balance;

    public BankAccount(String name, Integer balance) {
        this.name = name;
        this.balance = balance;
    }

    public Integer deposit(int money) throws InterruptedException {
        System.out.println("Inside deposit: money, thread - " + money + " " + Thread.currentThread());
//        Thread.sleep(1000);
        synchronized (this) {
            System.out.println("Inside deposit synchronized: money, thread - " + money + " " + Thread.currentThread());
            this.balance += money;
            Thread.sleep(200);
            System.out.println("Exiting deposit synchronized: money, thread - " + money + " " + Thread.currentThread());
        }

        System.out.println("Exiting deposit: money, thread - " + money + " " + Thread.currentThread());
        return this.balance;
    }
    // 500 milli seconds would be spent in the synchronized block

    public Integer withdraw(int money) throws InterruptedException {
        System.out.println("Inside withdraw: money, thread - " + money + " " + Thread.currentThread()); // entry section
//        Thread.sleep(1000);
        synchronized(this) { // critical section
            System.out.println("Inside deposit synchronized: money, thread - " + money + " " + Thread.currentThread());
            this.balance -= money;
            Thread.sleep(100);
            System.out.println("Exiting deposit synchronized: money, thread - " + money + " " + Thread.currentThread());
        }
        System.out.println("Exiting withdraw: money, thread - " + money + " " + Thread.currentThread()); // remainder section
        return this.balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
