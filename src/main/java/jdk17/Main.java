package jdk17;

public class Main {

    public static void main(String[] args) {
        testStrictfp();
    }

    public static void testStrictfp() {
        float aFloat = 0.6666666666666666666f;
        double aDouble = 0.88888888888888888d;
        double sum = aFloat + aDouble;
        System.out.println("sum: " + sum);
    }
}
