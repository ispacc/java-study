package java_8_in_action;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
        transactions.stream()
                .
    }

}
