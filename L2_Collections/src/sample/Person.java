package sample;

import java.util.Objects;

public class Person {

    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    Person(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return this.age == person.age && this.name.equals(person.name);
    }

    @Override
    public String toString() {
        return "{Person: id = " + this.id + ", name = " + this.name + ", age = " + this.age + "}";
    }

    public static void main(String[] args) {

        Person p1 = new Person(1, "Ram", 20);
        Person p2 = new Person(2, "Ram", 20);

//        Person p1 = new Person();
//        Person p2 = new Person();

//        Person p3 = p2;

//        System.out.println(p1 + " " + p2 + " " + p3);

        System.out.println(p1.equals(p2));



//        Integer a = 10;
//        Integer b = 10;



//        Integer a = new Integer(10);
//        Integer b = new Integer(10);
//
//        System.out.println(a == b);

        // a == b works in case Integer

    }
}
