package math;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("0.8");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.1");

        BigDecimal x = b.subtract(c);
        System.out.println(x);
    }
}
