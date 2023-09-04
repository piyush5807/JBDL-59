import java.util.ArrayList;

public class USCalculator extends AbstractCalculator {
    @Override
    public int add(int a, int b) {
        return (a + b) % 10000000;
    }

    @Override
    public int subtract(int a, int b) {
        return 0;
    }

    @Override
    public int multiply(int a, int b) {
        return (a * b) % 100000000;
    }

    public void random(){
        System.out.println("Inside random");
    }

    @Override
    public int divide(int a, int b) {
        return (a / b) % 1000000000;
    }

    public static void main(String[] args) {
        // Calling functions of USCalculator
        AbstractCalculator o1 = new USCalculator();
        USCalculator o2 = new USCalculator();

        Main obj1 = Main.getInstance();
        Main obj2 = Main.getInstance();
        Main obj3 = Main.getInstance();
        Main obj4 = Main.getInstance();
        Main obj5 = Main.getInstance();

        obj1.doSomething("1");
        obj2.doSomething("2");
        obj3.doSomething("3");
        obj4.doSomething("4");
        obj5.doSomething("5");




//        Not possible
//        USCalculator o4 = new AbstractCalculator();
//        o4.random();

        // Calling functions of Abstractcalculator
//        AbstractCalculator o3 = new AbstractCalculator() {
//            @Override
//            public int add(int a, int b) {
//                return 0;
//            }
//
//            @Override
//            public int multiply(int a, int b) {
//                return 0;
//            }
//
//            @Override
//            public int divide(int a, int b) {
//                return 0;
//            }
//        }



    }
}
