package 排序;

/**
 * @author berior
 * 快速排序
 */
public class QuickSort {
    private static int[] array;
    public QuickSort(int[] array) {
        this.array = array;
    }
    public void sort() {
        quickSort(array, 0, array.length - 1);
    }
    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int i  = begin, j = end, pivot = nums[begin];

        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, begin, j);

        quickSort(nums, begin, j - 1);
        quickSort(nums, j + 1, end);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
