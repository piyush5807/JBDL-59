import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamClass {

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // 4 + 16 + 36 + 64 + 100

        // Q1. Find the sum of squares of even nos.

//        System.out.println(calculate(arr));
//        System.out.println(calculateUsingStreams(arr));
//        System.out.println(calculateUsingStreamsAndLambdas(arr));

        // 1. Correctness
        // 2. Optimized // performance, memory constraints (talk later)
        // 3. Enhance code readability

    }

//    public static List<Integer> squareNumbers(int[]arr){
//        Arrays.stream(arr)
//                .boxed()
//                .filter(x -> x%2 == 0)
//                .map(x -> x*x)
//                .sorted()
//                .collect();
//    }

    // boxed function just converts an IntStream --> Stream<Integer>
    // This becomes useless
    public static int calculateUsingStreams(int[] arr){
        return Arrays.stream(arr)
                .boxed()
                .filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        }).map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) {
                        return integer * integer;
                    }
        }).reduce(0, new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) {
                        return integer + integer2;
                    }
        });
    }

    public static int calculateUsingStreamsAndLambdas(int[] arr){
        return Arrays.stream(arr)
                .boxed()
                .filter((x) -> x % 2 == 0)
                .map((x) -> x*x)
                .reduce(0, (x, y) -> x + y);
    }


    public static int calculate(int[]arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 == 0){
                sum += arr[i] * arr[i];
            }
        }

        return sum;
    }
}
