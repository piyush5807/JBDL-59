public class IndiaCalculator implements Calculator{
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b; // result can be -ve
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    // optional to implement default functions
//    @Override
//    public int divide(int a, int b) {
//        return Calculator.super.divide(a, b);
//    }
}
