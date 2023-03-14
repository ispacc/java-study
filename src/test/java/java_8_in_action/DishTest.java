package java_8_in_action;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class DishTest {

    @Test
    void method1() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        list.forEach(o -> {
            list.add("1");
        });
    }

    @Test
    void method2() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        ListIterator<String> stringListIterator = list.listIterator();
        while (stringListIterator.hasNext()) {
            stringListIterator.next();
            stringListIterator.add("---");
        }
        list.forEach(System.out::println);
    }
}
