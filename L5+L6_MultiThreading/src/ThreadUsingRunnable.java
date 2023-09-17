public class ThreadUsingRunnable {

    public static void main(String[] args) throws InterruptedException {

        Runnable t1 = () -> {
            System.out.println("Inside thread - " + Thread.currentThread());

            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("In thread - " + Thread.currentThread().getName() + ", slept for 60 secs, exiting now!!!!");
        };

        Thread thread = new Thread(t1);
        thread.setDaemon(true);
        thread.start();

        // never use thread.run - it's not going to a new thread
        // never start an already started thread

        Thread.sleep(5000);

        System.out.println("In thread - " + Thread.currentThread().getName() + ", slept for 5 secs, exiting now!!!!");



    }

//    private static class MyThread implements Runnable{
//
//        @Override
//        public void run() {
//            System.out.println("Inside thread - " + Thread.currentThread());
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
