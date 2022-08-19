package 排序;

/**
 * 冒泡排序
 */
public class BubbleSort {

    private static int[] array;
    public BubbleSort(int[] array) {
        this.array = array;
    }
    public void sort() {
        bubbleSort(array);
    }
    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
