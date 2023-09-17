import java.math.BigInteger;

public class Factorial {
    // 1. Correctness
    // 2. Optimization
    // 3. Code readability

    public static void main(String[] args) {
        int arr [] = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 35000};
        // 6.9 ~ 7 seconds

//        int[]arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        long start = System.currentTimeMillis(); // epoch time

        for(int i = 0 ; i < arr.length; i++){
            calculate(arr[i]);
//            System.out.println(calculate(arr[i]));
        }

        long end = System.currentTimeMillis();
        System.out.println("time spend = " + (end - start));

    }

    public static BigInteger calculate(int num){
        // 1*2*3....*100

        System.out.println("Inside calculate: thread - " + Thread.currentThread());

        BigInteger result = BigInteger.ONE;
        for(int i = 2; i <= num; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }


        return result;
    }


}
