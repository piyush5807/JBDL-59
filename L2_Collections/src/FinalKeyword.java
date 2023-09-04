public class FinalKeyword {

    /**
     * 1. Variables: can be initialized only in the constructor (for member variable) / static block (for static variable) or during declaration
     * 2. Functions: which cannot be overridden
     * 3. Classes: which cannot be inherited, here all functions are by default final functions
     */

    private final int count;
    private static int var;

    // You can define static variables inside non-static functions but vice versa i.e non-static variables
    // inside static functions are not allowed

//    static{
//        count = 20;
//    }

    FinalKeyword(){
        System.out.println("Inside constructor!!!");
        this.count = 10;
        var = 20;
    }

    public static void main(String[] args) {
        System.out.println("Inside main");
//        FinalKeyword obj = new FinalKeyword();

        FinalKeyword finalKeyword = new FinalKeyword();
//        finalKeyword.count = 20;
    }

}
