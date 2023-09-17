public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("Inside thread - " + currentThread());

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("In thread - " + Thread.currentThread().getName() + ", slept for 60 secs, exiting now!!!!");
    }
}
