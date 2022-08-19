package 排序;

public class Main {


    public static void main(String[] args) {
        int[] array = {34, 94, 4234, 42,54,12,7,93,234,776,324,867,345,234,90};
        BubbleSort ans = new BubbleSort(array);
        ans.print();
        System.out.println();
        ans.sort();
        ans.print();
    }
}
