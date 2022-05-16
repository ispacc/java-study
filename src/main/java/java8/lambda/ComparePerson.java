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

        // list.sort((o1, o2) -> o1.getAge() - o2.getAge());

        // list.sort(Comparator.comparing(Person::getAge));

        // list.forEach(System.out::println);

        // 使用Stream() Api
        list.stream().sorted(Comparator.comparing(Person::getAge))
                .forEach(System.out::println);
    }

    /**
     * 方法一： new Comparator<>()
     * @param list
     */
    public static void method1(ArrayList list) {
        Collections.sort(list, new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
    }

    /**
     * 方法二：lambda
     */
    public static ArrayList<Person> method2(ArrayList list) {
        Comparator<Person> res = (Person o1, Person o2) -> o1.getAge().compareTo(o2.getAge());
        list.sort(res);
        return list;
    }

    /**
     * 方法二：lambda优化+函数式接口
     */
    public static ArrayList<Person> method3(ArrayList list) {
        Comparator<Person> res = Comparator.comparing(Person::getAge);
        list.sort(res);
        return list;
    }

}
