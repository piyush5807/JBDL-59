public interface ParentInterface {

    default int subtract(int a, int b, int c) {
        return a - b - c;
    }

//    int hashCode();
//
//    int multiply(int a, int b);
}
