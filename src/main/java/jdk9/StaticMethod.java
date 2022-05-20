package jdk9;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class StaticMethod {
    public static void main(String[] args) {
        // 工厂方法创建集合
        List<String> stringList = List.of("a", "b", "c", "d");
        Set<String> stringSet = Set.of("a", "b", "c", "d");
        Map<String, Integer> stringIntegerMap = Map.of("key1", 1, "key2", 2, "key3", 3);
        Map<String, Integer> stringIntegerMap2 = Map.ofEntries(Map.entry("key1", 1), Map.entry("key2", 2));

        // 集合输出
        System.out.println(stringList);
        System.out.println(stringSet);
        System.out.println(stringIntegerMap);
        System.out.println(stringIntegerMap2);
        System.out.println();


    }
}
