package 单例模式;

/**
 * 单例模式
 * 即某个类在整个系统中只能有一个实例对象可被获取和使用的代码模式
 * 例： JVM中的Runtime类
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Singleton1.INSTANCE);
        System.out.println(Singleton2.INSTANCE);
        System.out.println(Singleton3.INSTANCE);
        System.out.println(Singleton4.getInstance());
        System.out.println(Singleton5.getInstance());
        System.out.println(Singleton6.getInstance());
    }
}
