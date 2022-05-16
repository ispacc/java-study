package 单例模式;

/**
 * 饿汉式
 * 静态变量
 */
public class Singleton1 {
    private Singleton1() {}

    public static final Singleton1 INSTANCE = new Singleton1();
}
