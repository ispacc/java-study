package 方法的参数传递机制;

import java.util.Arrays;

/**
 *  1、形参是基本数据类型
 *      传递数据值
 *  2、实参是引用数据类型
 *      传递地址值
 *      特殊的类型：String、包装类等对象不可变性
 */
public class Demo {
    public static void main(String[] args) {
        int j = 1;
        String str = "hello";
        Integer num = 200;
        int[] arr = {1, 2, 3, 4, 5};
        MyData my = new MyData();

        change(j, str, num, arr, my);

        System.out.println(j);
        System.out.println(str);
        System.out.println(num);
        System.out.println(Arrays.toString(arr));
        System.out.println(my.a);
    }

    public static void change(int j, String s, Integer n, int[] a, MyData m) {
        j += 1;
        s += "world";
        n += 1;
        a[0] += 1;
        m.a += 1;
    }
}

class  MyData {
    int a = 10;
}
