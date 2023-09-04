import java.util.Comparator;

public class Person implements Comparable<Person> {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {
//        Person p1 = new Person(20, "DEF");
//        Person p2 = new Person(20, "DEF");
//
//        int result = p1.compareTo(p2);
//        if(result < 0){
//            System.out.println("P1 is smaller");
//        }else if(result > 0){
//            System.out.println("P2 is smaller");
//        }else{
//            System.out.println("Both are same");
//        }

        Main obj1 = Main.getInstance();
        Main obj2 = Main.getInstance();
        Main obj3 = Main.getInstance();

        System.out.println(obj1 + " " + obj2 + " " + obj3);
    }

//    @Override
//    public int compare(Person o1, Person o2) {
//        if(o1.age == o2.age){
//            return o1.name.compareTo(o2.name);
//        }
//
//        return o1.age - o2.age;
//    }

    @Override
    public int compareTo(Person o) {
        if(this.age == o.age){ // this == p1, o = p2
            return this.name.compareTo(o.name);
        }

        return this.age - o.age;
    }
}
