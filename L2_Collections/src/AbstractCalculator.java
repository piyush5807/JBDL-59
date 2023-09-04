public abstract class AbstractCalculator {

    public abstract int add(int a, int b);

    public int subtract(int a, int b){
        return Math.abs(a - b);
    }
    public abstract int multiply(int a, int b);
    public abstract int divide(int a, int b);


    // You can define non-abstract functions inside abstract classes
    // but you cannot define an abstract function in a non-abstract class
}
