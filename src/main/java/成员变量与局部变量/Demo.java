package 成员变量与局部变量;

/**
 * 就近原则
 * 成员变量： 类变量、 实例变量
 *
 * 存放位置
 *  局部变量：栈
 *  实例变量：堆
 *  类变量： 方法区
 */
public class Demo {
    static int s;
    int i;
    int j;
    {
        int i = 1;
        i++;
        j++;
        s++;
    }
    public void test(int j) {
        i++;
        j++;
        s++;
    }

    public static void main(String[] args) {
        Demo obj1 = new Demo();
        Demo obj2 = new Demo();
        obj1.test(10);
        obj1.test(20);
        obj2.test(30);
        System.out.println(obj1.i + "," + obj1.j + "," + obj1.s);
        System.out.println(obj2.i + "," + obj2.j + "," + obj2.s);
    }
}
