package jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        System.out.println(strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(", ")));
    }
}
