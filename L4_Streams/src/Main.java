import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        squareNumber();
//        toggle();
//        toggleUsingLambda();
//        System.out.println("Hello world!");
//
//        FI obj1 = new FIClass();
//        obj1.add(10, 20, 30); // way 1 FIClass
//        FI obj2 = new FIClass();
//        obj2.add(20, 30, 40);
//
//        FI obj3 = new FI() {
//            @Override
//            public int add(int a, int b, int c) {
//                int d = a + b + c;
//                return d;
//            }          // this is an anonymous inner class , way 2 FI#Anonymous
//
//        };
//
//        FI obj4 = new FI() {
//            @Override
//            public int add(int a, int b, int c) {
//                int d = a + b + c;
//                return d;
//            };
//        };
//
//
//
//        // 1. Request  2. Response 3. Body
//        FI obj5 = (a, b, c) -> a + b + c;   // way 3, you are not creating an object, but there will be an object created of annonymous inner class
//
//        System.out.println(obj1.add(10, 20, 30));
//        System.out.println(obj2.add(10, 20, 30));

        // functional interfaces - interfaces which have only 1 non-overriding abstract method are known as functional interfaces
    }

    // Q1. Given a string you have to toggle it.
    // Ex: cIty  => CiTY

    public static void toggle(){

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                String str = "";
                for(int i = 0; i < s.length(); i++){
                    if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                        str += (char)(s.charAt(i) - ('a' - 'A'));
                    }else{
                        str += (char)(s.charAt(i) + ('a' - 'A'));
                    }
                }

                System.out.println(str);
            }
        };

        consumer.accept("cIty");
    }

    public static void toggleUsingLambda(){

        Consumer<String> consumer = (word) -> {
                String str = "";
                for(int i = 0; i < word.length(); i++){
                    if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z'){
                        str += (char)(word.charAt(i) - ('a' - 'A'));
                    }else{
                        str += (char)(word.charAt(i) + ('a' - 'A'));
                    }
                }

                System.out.println(str);
        };

        consumer.accept("cIty");
    }

    // Q2. Given a number string, you have to return square of the number
    // Ex: "80" => 6400


    public static void squareNumber(){
        String numberStr = "90";

        Function<String, Double> function = (str) -> Math.pow(Integer.parseInt(str), 2);

        System.out.println(function.apply(numberStr));
    }
}