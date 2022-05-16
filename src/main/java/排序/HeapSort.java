package 排序;

/**
 * @author berior
 * 堆排序
 */
public class HeapSort {
    private static int[] array;
    public HeapSort(int[] array) {
        this.array = array;
    }
    public void sort() {
        heapSort(array);
    }
    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private void heapSort(int[] arr) {
        array = buildMaxHeap(array); //初始建堆，array[0]为第一趟值最大的元素
        for (int i = array.length - 1; i >= 1; i--) {
            int temp = array[0];  //将堆顶元素和堆底元素交换，即得到当前最大元素正确的排序位置
            array[0] = array[i];
            array[i] = temp;
            adjustHeap2(array, 0, i);  //整理，将剩余的元素整理成大顶堆
        }
    }

    private static int[] buildMaxHeap(int[] array) {
        //从最后一个节点array.length-1的父节点（array.length-1-1）/2开始，直到根节点0，反复调整堆
        for(int i=(array.length-2)/2;i>=0;i--){
            adjustHeap2(array, i, array.length);
        }
        return array;
    }

    private static void adjustHeap2(int[] array, int k, int length) {
        int k1=2*k+1;
        if(k1<length-1 && array[k1]<array[k1+1]){
            k1++;
        }
        if(k1>length-1||array[k]>=array[k1]){
            return;
        }else{
            int temp = array[k];  //将堆顶元素和左右子结点中较大节点交换
            array[k] = array[k1];
            array[k1] = temp;
            adjustHeap2(array,k1,length);
        }
    }



    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
