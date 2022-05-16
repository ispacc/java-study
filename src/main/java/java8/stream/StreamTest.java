package java8.stream;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    /**
     * 返回名字长度等于4的值，并加上前缀"This is"
     */
    @Test
    public void streamDemo() {
        List<String> nameList = Arrays.asList("Darcy", "Chris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter");
        nameList.stream()
                .filter(s -> s.length() == 4)
                .map(s ->"This is " + s)
                .forEach(System.out::println);
    }

    @Test
    public void createStream() throws FileNotFoundException {
        List<String> nameList = Arrays.asList("Darcy", "Chris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter");
        String[] nameArr = {"Darcy", "Chris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter"};
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
        IntStream rangeStream = IntStream.range(1, 10);
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
        Random random = new Random();
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



}
