import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Person {

    private int id;
    private int age;
    private String name;

    public Person(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return id == person.id && age == person.age && Objects.equals(name, person.name);
//    }

    @Override
    public int hashCode() {
        return 10;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        HashMap<Person, Boolean> map = new HashMap<>();

        Person p1 = new Person(1, 20, "ABC");
        Person p2 = new Person(1, 20, "ABC");


        System.out.println(p1 + " " + p2);

        System.out.println(p1.hashCode() + " " + p2.hashCode());

        map.put(p1, true);
        map.put(p2, false);


        System.out.println(map);

        // 1. same hashcode, diff object >> collision
        // 2. same hashcode, same object >> duplication, incoming object will be overriding the existing one
        // 3. diff hashcode, same object >> new object, no collision
        // 4. diff hashcode, diff object >> new object, no collision


        System.out.println(map.get(p1) + " " + map.get(p2));

//        Integer a = 100;
//        Integer b = 100;
//
//        System.out.println(a == b);

    }
}
