import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        int[]arr = {2, 12, 4, 50, 62, 7, 8, 9, 11, 13, 15, 19, 21};

        // count how many odd number are there
        // Task 1: Check whether a number is odd or not
        // Task 2: Sum all the odd number

        // Stream will execute only if it has a terminal function

        // Intermediate functions / Non-terminal
        // Terminal functions

//        Arrays.stream(arr)
//                .map(r -> {
//                    System.out.println("Inside map block: r = " + r);
//                    return r*r;
//                })
//                .forEach(x -> System.out.println(x));
//                .forEach(x -> {
//                    System.out.println("Inside for each block: x =" + x);
//                });


        // Q1. Given an integer array, you have to find the first odd number
        // Ans. arr = {6, 2, 4, 5}

        /**
         * Two types of streams:
         * 1. Sequential - By default, runs in a single thread
         * 2. Parallel - Runs in multiple threads at any given instant of time
         */

//        System.out.println(findFirstOddNumber(arr));

//        for(int i = 0; i < 1000; i++){
////            System.out.println((arr));
//            System.out.println(calculateSum(arr));
//        }

//        System.out.println(calculateSumSeq(arr));

        System.out.println(Runtime.getRuntime().availableProcessors());

        System.out.println(calculateSum(arr));

    }

    public static Integer calculateSum(int[]arr){
        return Arrays.stream(arr)
                .parallel()
                .filter(x -> {
//                    System.out.println("In filter, x = " + x + ", thread = " + Thread.currentThread().getName()) ;
                    return x > 0;
                })
                .reduce(0, (x, y) -> {
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                    System.out.println("In reduce, (x, y) = " + x + "," + y + ", thread = " + Thread.currentThread().getName()) ;
                    return x + y;
                });
    }

    public static Integer calculateSumSeq(int[]arr){
        return Arrays.stream(arr)
                .filter(x -> {
//                    System.out.println("In filter, x = " + x + ", thread = " + Thread.currentThread().getName()) ;
                    return x > 0;
                })
                .reduce(1, (x, y) -> {
//                    System.out.println("In reduce, (x, y) = " + x + "," + y + ", thread = " + Thread.currentThread().getName()) ;
                    return x + y;
                });
    }

//    public static void printAllNumbers(int[]arr){
//        Arrays.stream(arr)
//                .parallel()
//                .filter(x -> {
//                    System.out.println("Inside filter block: x = " + x + ", thread = " + Thread.currentThread().getName());
//                    return x > 0;
//                })
//                .forEach(x -> System.out.println("Inside foreach - x = " + x + ", thread = " + Thread.currentThread().getName()));
//    }

    public void printAllNumbers(int[]arr){
        Arrays.stream(arr)
                .parallel()
                .filter(x -> {
                    return x > 0;
                })
                .forEach(this::add); //
    }

    // method referencing can only be used when the number and order of input in a lambda is same as the
    // number of arguments for the corresponding function
    public int calculateSum(int[]arr){
        Arrays.stream(arr)
                .reduce(0, this::add);
    }

    private String add(String a, String b){
        return a + b;
    }

    // int[]arr = {2, 12, 4, 50, 62, 7, 8, 9};
    public static Integer findAnyOddNumber(int[]arr){
//        Set<Integer> set = new HashSet<>();
//        // 2, 12, 4, 50, 62, 7, 8, 9, 11, 13, 15, 19, 21
//        set.add(2);
//        set.add(12);
//        set.add(4);
//        set.add(50);
//        set.add(62);
//        set.add(8);
//        set.add(9);
//        set.add(15);
//        set.add(11);
//        set.add(7);
//        set.add(13);
//        set.add(19);
//        set.add(21);
//
//        System.out.println(set);

//        return set.stream()
//                .parallel()
//                .filter(x -> {
//                    return x % 2 == 1;
//                })
//                .findFirst().get();

        return 0;

    }

    public static Integer findFirstOddNumberUsingStreams(int[]arr){
        return Arrays.stream(arr)
                .parallel()
                .filter(x -> {
                    System.out.println("Inside filter block: x = " + x + ", thread = " + Thread.currentThread().getName());
                    return x % 2 == 1;
                })
                .findFirst()
                .getAsInt();
    }

    public static Integer findFirstOddNumber(int[]arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println("i = " + arr[i] + ", inside thread - " + Thread.currentThread().getName());
            if(arr[i] % 2 == 1){
                return arr[i];
            }
        }

        return -1;
    }


}
