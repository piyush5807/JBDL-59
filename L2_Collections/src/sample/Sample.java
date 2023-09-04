package sample;

public class Sample {
    // Access modifiers

    /**
     * 1. Private - only within same class
     * 2. default - any class of the same package
     * 3. protected - any class of the same package + child classes of different packages
     * 4. public - accessible everywhere
     */

    protected int count;

    /**
     * Inside the class
     * Outside the class but within same package
     * Outside package also | globally
     */

    public static void main(String[] args) {
        Sample s = new Sample();
    }
}
