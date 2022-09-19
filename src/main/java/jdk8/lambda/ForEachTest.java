package jdk8.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;


/**
 * 可以使用forEach对list、array、map等集合进行遍历。
 *
 */
public class ForEachTest {

    /**
     * forEach : Array
     */
    @Test
    public void method1() {
        String[] array = {"java", "nodejs", "wdbyte.com"};
        Arrays.stream(array).forEach(System.out::println);
    }

    /**
     * 可排序遍历
     */
    @Test
    public void method2() {
        Stream<String> stream = Stream.of("java", "nodejs", "c++", "wdbyte.com");
        stream.parallel().forEachOrdered(System.out::println);
    }
    
    @Test
    public void method3() {
        new Thread(() -> System.out.println("Hello World")).start();
    }

}
