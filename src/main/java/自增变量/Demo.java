package 自增变量;

/**
 * = 右边的从左到右加载值依次压入操作数栈
 * 自增自减直接修改变量的值，不经过操作数栈
 * 临时结果存在操作数栈
 *
 * 局部变量表  操作数栈
 */
public class Demo {
    public static void main(String[] args) {
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println(i);
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }
}
