package java_8_in_action;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreamTest {
    public static void main(String[] args) {
        System.out.println("Sequential sum done in:" +
                measureSumPerf(ParallelStreamTest::sequentialSum, 10_000_000) + " msecs");

        System.out.println("parallelsSum sum done in:" +
                measureSumPerf(ParallelStreamTest::parallelsSum, 10_000_000) + " msecs");


        System.out.println("rangedSum sum done in:" +
                measureSumPerf(ParallelStreamTest::rangedSum, 10_000_000) + " msecs");

        System.out.println("parallelRangedSum sum done in:" +
                measureSumPerf(ParallelStreamTest::parallelRangedSum, 10_000_000) + " msecs");
    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long parallelsSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
//            System.out.println("Result: "+sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }

}
