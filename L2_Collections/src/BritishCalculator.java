public class BritishCalculator implements Calculator{
    @Override
    public int add(int a, int b) {
        return (a + b) % 1000000;
    }

    @Override
    public int subtract(int a, int b) {
        return Math.abs(a - b); // cannot be -ve
    }

    @Override
    public int multiply(int a, int b) {
        return (a * b) % 100000;
    }
}
