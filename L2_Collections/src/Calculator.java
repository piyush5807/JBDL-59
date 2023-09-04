public interface Calculator {

    // all default functions are non-abstract

    int add(int a, int b);
    int subtract(int a, int b);
    int multiply(int a, int b);

    default int divide(int a, int b){
        return a / b;
    }
}
