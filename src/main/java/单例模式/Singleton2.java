package 单例模式;

import java.time.Instant;

/**
 * 饿汉式
 * 静态代码块
 */
public class Singleton2 {
    private Singleton2() {}

    public static final Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }
}
