package 线程池;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("Hello World")) {
            @Override
            public void run() {
                System.out.println("zi run()");
            }
        }.start();

    }

}
