import java.util.Comparator;

@FunctionalInterface
public interface FI  extends ParentInterface{

    int add(int a, int b, int c);

//    int subtract(int a, int b, int c); // it became abstract
}
