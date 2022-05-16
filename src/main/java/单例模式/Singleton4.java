package 单例模式;

/**
 * 懒汉式
 * 适用于单线程
 * 加锁 效率较慢
 */
public class Singleton4 {
    private Singleton4() {}
    private static Singleton4 instance;

    public static synchronized Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}
