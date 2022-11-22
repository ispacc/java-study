package java_8_in_action;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TraderTest {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");


    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    // (1) 找出2011年发生的所有交易，并按交易额排序（从高到低）。
    @Test
    public void method1() {
        List<Transaction> res = transactions.stream()
                .filter(s -> s.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue, Comparator.reverseOrder()))
                .toList();
        System.out.println(res);
    }

    // 交易员都在哪些不同的城市工作过
    @Test
    public void method2() {
        var collect = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .collect(Collectors.toSet());
        System.out.println(collect);
    }

    // 查找所有来自于剑桥的交易员，并按姓名排序
    @Test
    public void method3() {
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
    }

    // 返回所有交易员的姓名字符串，按字母顺序排序
    @Test
    public void method4() {
        String reduce = transactions.stream()
                .map(s -> s.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        System.out.println(reduce);
    }

    // 有没有交易员是在米兰工作的
    @Test
    public void method5() {
        boolean milan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milan);
    }

    // 打印生活在剑桥的交易员的所有交易额
    @Test
    public void mehotd6() {
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    // 所有交易中，最高的交易额是多少
    @Test
    public void method7() {
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(max);
    }
}
