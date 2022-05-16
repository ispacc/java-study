package java8.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalTest {

    /**
     * 创建 Optional
     */

    @Test
    public void createOptionalTest() {
        Optional<String> optional1 = Optional.of("Hello");
        Optional<Object> optional2 = Optional.empty();
        Optional<Object> optional3 = Optional.ofNullable(null);

        System.out.println(optional1);
        System.out.println(optional2);
        System.out.println(optional3);
    }

    /**
     * 检查是否有值
     */
    @Test
    public void checkOptionalTest() {
        Optional<String> helloOptional = Optional.of("Hello");
        System.out.println(helloOptional.isPresent());

        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional.isPresent());
    }

    /**
     * 如果没有值，会抛异常
     */
    @Test
    public void getTest() {
        Optional<String> stringOptional = Optional.of("hello");
        System.out.println(stringOptional.get());
        // 如果没有值，会抛异常
        Optional<String> emptyOptional = Optional.empty();
        System.out.println(emptyOptional.get());
    }

    /**
     * orElse 和 orElseGet 的区别
     * orElse 无论是否值都运行，
     * orElseGet有值不运行
     */
    @Test
    public void orElseAndOrElseGetTest() {
        // 如果没有值，默认值
        Optional<String> emptyOptional = Optional.empty();
        System.out.println("空Optional.orElse");
        String orElse = emptyOptional.orElse(getDefault());
        System.out.println("空Optional.orElseGet");
        String orElseGet = emptyOptional.orElseGet(() -> getDefault());
        System.out.println("空Optional.orElse结果："+orElse);
        System.out.println("空Optional.orElseGet结果："+orElseGet);
        System.out.println("--------------------------------");
        // 如果没有值，默认值
        Optional<String> stringOptional = Optional.of("hello");
        System.out.println("有值Optional.orElse");
        orElse = stringOptional.orElse(getDefault());
        System.out.println("有值Optional.orElseGet");
        orElseGet = stringOptional.orElseGet(() -> getDefault());
        System.out.println("有值Optional.orElse结果："+orElse);
        System.out.println("有值Optional.orElseGet结果："+orElseGet);
    }

    @Test
    public void functionTest() {
        // filter 过滤
        Optional<Integer> optional123 = Optional.of(123);
        optional123.filter(num -> num == 123).ifPresent(num -> System.out.println(num));

        Optional<Integer> optional456 = Optional.of(456);
        optional456.filter(num -> num == 456).ifPresent(num -> System.out.println(num));

        // map 转换
        Optional<Integer> optional789 = Optional.of(789);
        optional789.map(String::valueOf).map(String::length).ifPresent(length -> System.out.println(length));
    }









    public String getDefault() {
        System.out.println("   获取默认值中..run getDeafult method");
        return "hello";
    }



}

