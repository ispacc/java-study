package jdk16;

public class PersonImpl {
    public static void main(String[] args) {
        Person person = new Person("admin", 145);
        System.out.println(person.age());
        System.out.println(person.toString());
    }
}
