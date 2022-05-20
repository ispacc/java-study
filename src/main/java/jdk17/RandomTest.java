package jdk17;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class RandomTest {
    public static void main(String[] args) {
        // RandomGeneratorFactory.all().forEach(o -> System.out.println(o.name()));

        RandomGeneratorFactory<RandomGenerator> xoroshiro128PlusPlus = RandomGeneratorFactory.of("Xoroshiro128PlusPlus");
        RandomGenerator generator = xoroshiro128PlusPlus.create(System.currentTimeMillis());
        for (int i = 0; i < 5; i++) {
            System.out.println(generator.nextInt(10));
        }
    }
}
