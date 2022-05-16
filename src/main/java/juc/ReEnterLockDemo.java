package juc;

/**
 *  可重入锁Demo
 *  同一线程可以多次获得同一把锁（递归锁）
 */
public class ReEnterLockDemo {
    static Object objectLockA = new Object();

    public static void method1() {
        new Thread(() -> {
            synchronized (objectLockA) {
                System.out.println(Thread.currentThread().getName() + "\t" + "-----外层调用");
                synchronized (objectLockA) {
                    System.out.println(Thread.currentThread().getName() + "\t" + "-----中层调用");
                    synchronized (objectLockA) {
                        System.out.println(Thread.currentThread().getName() + "\t" + "-----内层调用");
                    }
                }
            }
        }, "t1").start();
    }

    public static void main(String[] args) {
        method1();
    }
}
