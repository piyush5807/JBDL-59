import java.math.BigInteger;
import java.util.stream.IntStream;

public class FactorialUsingMT {

    public static void main(String[] args) throws InterruptedException {
        int arr [] = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 35000};
//        int[]arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Available processors - " + Runtime.getRuntime().availableProcessors());

        MyThread[] threads = new MyThread[arr.length];

        long start = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i++){
            threads[i] = new MyThread(arr[i]);
            threads[i].start();
        }
        for(int i = 0; i < arr.length; i++){
            threads[i].join();
            System.out.println("For element = " + arr[i] + ", result = " + threads[i].result);

        }

        long end = System.currentTimeMillis();
        System.out.println("time taken = " + (end - start));


        // Useless because we are creating our own threads
//        IntStream.range(0, arr.length)
//                .boxed()
//                .parallel()
//                .map(i -> {
//                    System.out.println("Inside 1st map, i = " + i);
//                    threads[i] = new MyThread(arr[i]);
//                    threads[i].start();
//                    return i;
//                }).map(i -> {
//                    System.out.println("Inside 2nd map, i = " + i);
//                    try {
//                        threads[i].join();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return i;
//                }).forEachOrdered(i -> System.out.println("Inside foreach, i = " + i));


    }

    private static class MyThread extends Thread {

        private int num;
        private BigInteger result;

        MyThread(int num){
            this.num = num;
            this.result = BigInteger.ONE;
        }

        @Override
        public void run() {
            calculate();
        }

        public void calculate(){
            for(int i = 2; i <= num; i++){
                result = result.multiply(BigInteger.valueOf(i));
            }
        }
    }
}
