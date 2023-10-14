package algorithm_01_array;

import java.util.Arrays;

public class sort_quickSort {
    private static void quickSort0(int[] array, int low, int high) {
        if (low >= high) return;
        int i = low, j = high, index = array[i]; // 取最左边的数作为基准数
        while (i < j) {
            // 从右向左 找第一个小于index的数/交换
            while (i < j && array[j] >= index) j--;
            if (i < j) array[i++] = array[j];
            // 从左向右 找第一个大于index的数/交换
            while (i < j && array[i] < index) i++;
            if (i < j) array[j--] = array[i];
        }
        array[i] = index; // 将基准数填入最后的坑
        quickSort(array, low, i - 1);
        quickSort(array, i + 1, high);
    }
    public static void main(String[] args) {
        int[] arr = {7,3,1,2,5,8,6,4,9};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int l, int r) {
        if(l >= r) return;
        int i = l;
        int j = r;
        int index = arr[i];
        while (i < j) {
            while(i < j && arr[j] >= index) j--;
            if (i < j) arr[i++] = arr[j];
            while(i < j && arr[i] < index) i++;
            if (i < j) arr[j--] = arr[i];
        }
        arr[i] = index;
        quickSort(arr, l, i-1);
        quickSort(arr, i+1, r);
    }

}
