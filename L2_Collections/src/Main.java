import sample.Sample;

public class Main implements Cloneable{

    private static Main object = null;

    private int count;
    private static boolean isWorking = true;

    private Main(){
        System.out.println("Inside Main constructor, object = " + this);
        this.count = 10;
    }

    public void doSomething(String userId){
        // reserving movie tickets for user having userId
    }

    public static Main getInstance(){

        // we kept a local variable which is storing this object, initially it would be null
        // if the variable was null, we invoke the private constructor, set the variable with the this object
        // return the object

        if(object == null){
            object = new Main(); // invoke the constructor and get this object
        }

        return object;
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("Hello world!");

        Main obj = getInstance();
        Main obj2 = (Main)obj.clone();

        System.out.println(obj2);
    }
}