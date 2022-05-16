package java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparePerson {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<Person>();
        list.add(new Person("A", 44));
        list.add(new Person("B", 17));
        list.add(new Person("C", 22));
        list.add(new Person("D", 32));
        list.add(new Person("E", 2));

        method1(list);

        for (var children : list) {
            System.out.println(children);
        }


    }

    // 方法一：new Comparator<>()
    public static void method1(ArrayList list) {
        Collections.sort(list, new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
    }
}
