package jdk8.lambda;

public class lambdaTest {
    public static void main(String[] args) {
        Runnable a = new Runnable(){
            public void run() {
                System.out.println("Hello World");
            }
        };
        a.run();

        Runnable b = () -> System.out.println("Hello");
        b.run();

    }
}
