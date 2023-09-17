public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");
        System.out.println(Thread.currentThread());

//        Thread thread = new Thread();
//        thread.setPriority(10); // 10
//
//        thread.start();

//        System.out.println(thread);

        MyThread thread = new MyThread();
        thread.setDaemon(true);
        thread.start();
        thread.setPriority(10);
        // never use thread.run - it's not going to a new thread
        // never start an already started thread

        Thread.sleep(5000);

        System.out.println("In thread - " + Thread.currentThread().getName() + ", slept for 10 secs, exiting now!!!!");

//        System.out.println("Inside thread main.... " + Thread.currentThread());
//        long sum = 0;
//        for(int i = 0; i < 10000000; i++){
//            sum += i;
//        }
//        System.out.println("sum = " + sum);
    }

//    private static class MyThread extends Thread{
//
//        // arr = [1000, 2000, 10000, ....]
//        // factorials = [x, y, z, ....]
//
//        @Override
//        public void run() {
//            System.out.println("Inside thread - " + currentThread());
//
//            try {
//                Thread.sleep(60000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//            System.out.println("In thread - " + Thread.currentThread().getName() + ", slept for 60 secs, exiting now!!!!");
//        }
//    }
}