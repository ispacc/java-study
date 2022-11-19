package jdk8.stream;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static final String[] PEOPLE = {"Darcy", "Chris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter"};
    /**
     * 返回名字长度等于4的值，并加上前缀"This is"
     */
    @Test
    public void streamDemo() {
        List<String> nameList = Arrays.asList(PEOPLE);
        nameList.stream()
                .filter(s -> s.length() == 4)
                .map(s -> "This is " + s)
                .forEach(System.out::println);
    }

    @Test
    public void createStream() throws FileNotFoundException {
        List<String> nameList = Arrays.asList(PEOPLE);
        String[] nameArr = PEOPLE;
        // 集合获取 Stream 流
        Stream<String> nameListStream = nameList.stream();
        // 集合获取并行 Stream 流
        Stream<String> nameListStream2 = nameList.parallelStream();
        // 数组获取 Stream 流
        Stream<String> nameArrStream = Stream.of(nameArr);
        // 数组获取 Stream 流
        Stream<String> nameArrStream1 = Arrays.stream(nameArr);
        // 文件流获取 Stream 流
        BufferedReader bufferedReader = new BufferedReader(new FileReader("README.md"));
        Stream<String> linesStream = bufferedReader.lines();
        // 从静态方法获取流操作
        IntStream rangeStream = IntStream.range(1, 105);
        rangeStream.limit(10).forEach(num -> System.out.print(num+","));
        System.out.println();
        IntStream intStream = IntStream.of(1, 2, 3, 3, 4);
        intStream.forEach(num -> System.out.print(num+","));
    }

    /**
     * 并行计算
     */
    @Test
    public void main() {
        // 生成自己的随机数流，取一千万个随机数
        Random random = new SecureRandom();
        Stream<Integer> generateRandom = Stream.generate(random::nextInt);
        List<Integer> numberList = generateRandom.limit(10000000).collect(Collectors.toList());

        // 串行 - 把一千万个随机数，每个随机数 * 2 ，然后求和
        long start = System.currentTimeMillis();
        int sum = numberList.stream()
                .map(number -> number * 2)
                .mapToInt(x -> x)
                .sum();
        long end = System.currentTimeMillis();
        System.out.println("串行耗时："+(end - start)+"ms，和是:"+sum);

        // 并行 - 把一千万个随机数，每个随机数 * 2 ，然后求和
        start = System.currentTimeMillis();
        sum = numberList.parallelStream()
                .map(number -> number * 2)
                .mapToInt(x -> x)
                .sum();
        end = System.currentTimeMillis();
        System.out.println("并行耗时："+(end - start)+"ms，和是:"+sum);
    }

    @Test
    public void simpleTest(){
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        int[] factor = new int[] { 2 };
        Stream<Integer> stream = numbers.stream()
                .map(e -> e * factor[0]);
        factor[0] = 0;
        stream.forEach(System.out::println);
    }

    @Test
    public void simpleTest12(){
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        int[] factor = new int[] { 2 };
        Stream<Integer> stream = numbers.stream()
                .map(e -> e * factor[0]);
        factor[0] = 0;
        stream.forEach(System.out::println);
    }

    @Test
    public void simpleTest1() {
        List<String> list = Arrays.asList("11", "3", "2");
        String collect = list.stream()
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(collect);
    }

    @Test
    public void simpleTest2() {
        class Person {
            String name;
            int age;

            Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            public int getAge() {
                return this.age;
            }

            @Override
            public String toString() {
                return name;
            }
        }
        // 构建一个 Person 集合
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));
        Map<Integer, List<Person>> person = persons.stream()
                .collect(Collectors.groupingBy(p -> p.age));
        person.forEach((age, p) -> {
            System.out.printf("age %s: %s\n", age, p);
        });

        // 内置统计对象
        IntSummaryStatistics collect = persons.stream()
                .collect(Collectors.summarizingInt(Person::getAge));
        System.out.println(collect);

        System.out.println("------------------------------");

        // 人名连接
        String collect1 = persons.stream()
                .map(p -> p.name)
                .collect(Collectors.joining("and"));

        System.out.println("------------------------------");
        Map<Integer, String> collect2 = persons.stream()
                .collect(Collectors.toMap(
                        p -> p.age,
                        p -> p.name,
                        (name1, name2) -> name1 + ";" + name2
                ));
        System.out.println(collect2.get(23));
    }

    @Test
    public void simpleTest3() {
        class Foo {
            String name;
            List<Bar> bars = new ArrayList<>();

            class Bar {
                String name;

                Bar(String name) {
                    this.name = name;
                }
            }

            Foo(String name) {
                this.name = name;
            }
        }




    }
}
