import java.math.BigInteger;
import java.util.Arrays;

public class FactorialUsingParallelStreams {

    public static void main(String[] args) {
        int arr [] = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 35000};
//        int[]arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        long start = System.currentTimeMillis();
        Arrays.stream(arr)
                .parallel()
                .mapToObj(FactorialUsingParallelStreams::calculate)
                .forEachOrdered(x -> {});

        long end = System.currentTimeMillis();

        System.out.println("time taken = " + (end - start));
    }

    public static BigInteger calculate(int num){
        BigInteger result = BigInteger.ONE;
        for(int i = 2; i <= num; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
