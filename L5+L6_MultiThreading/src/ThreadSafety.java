public class ThreadSafety {

    public static void main(String[] args) throws InterruptedException {

        // inside main thread

//        System.out.println(bankAccount.deposit(100));
//        System.out.println(bankAccount.withdraw(200));

//        for(int i = 0; i < 100; i++) {
        long start = System.currentTimeMillis();
            BankAccount bankAccount = new BankAccount("1", 1000);
            MyThread t1 = new MyThread(bankAccount, true, 100);
            MyThread t2 = new MyThread(bankAccount, false, 200);
            MyThread t3 = new MyThread(bankAccount, true, 500);
            t1.start();
            t2.start();
            t3.start();

            t1.join();
            t2.join();
            t3.join();

            System.out.println(bankAccount.getBalance());
            long end = System.currentTimeMillis();

            System.out.println("time taken = " + (end - start));
//        }
    }

    private static class MyThread extends Thread {

        private BankAccount bankAccount;
        private boolean isDeposit; // false => withdrawal,

        private Integer amount;

        public MyThread(BankAccount bankAccount, boolean isDeposit, Integer amount) {
            this.bankAccount = bankAccount;
            this.isDeposit = isDeposit;
            this.amount = amount;
        }

        @Override
        public void run() {
            // Entry section
            try {
                if(isDeposit) {
                    this.bankAccount.deposit(amount);
                }else {
                    this.bankAccount.withdraw(amount);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Exit / Remainder section
        }
    }
}
