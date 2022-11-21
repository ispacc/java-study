package java_8_in_action;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DishTest {

    List<Dish> menu= Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    @Test
    public void method1() {
        List<String> words = Arrays.asList("Hello", "World");

        // 返回列表中不相同的字母
        List<String[]> result = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());
        result.forEach(System.out::println);

        // 给定两个数字列表，如何返回所有的数对
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers1
                .stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j}))
                .toList();
        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
    }

    @Test
    public void reduceTest() {
        // 怎样用map和reduce方法数一数流中有多少个菜呢？
        int reduce = menu.stream().map(d -> 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
    }
}
