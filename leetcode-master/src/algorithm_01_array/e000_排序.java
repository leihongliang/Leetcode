package algorithm_01_array;


import java.util.Arrays;

public class e000_排序 {

    public static void quickSort0(int[] arr, int l, int r) {
        if (l >= r) return;
        int i = partition(arr, l, r);
        quickSort0(arr, l, i - 1);//< 区域
        quickSort0(arr, i + 1, r);//> 区域
    }

    public static int partition(int[] arr, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            // 找到首个小于中心轴的数
            while (i < j && arr[j] >= arr[l]) j--;
            // 找到首个大于中心轴的数
            while (i < j && arr[i] <= arr[l]) i++;
            // 你俩先换
            swap(arr, i, j);
        }
        // 直接找到中心轴的最终位置
        swap(arr, i, l);
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        while (i < j) {
            // 找到首个小于中心轴的数
            while (i < j && arr[j] >= arr[l]) j--;
            // 找到首个大于中心轴的数
            while (i < j && arr[i] <= arr[l]) i++;
            // 你俩先换
            swap(arr, i, j);
        }
        // 直接找到中心轴的最终位置
        swap(arr, i, l);
        quickSort(arr, l, i - 1);//< 区域
        quickSort(arr, i + 1, r);//> 区域
    }


    public static void main(String[] args) {
        int[] arr = {7,3,1,2,5,8,6,4,9};
        quickSort(arr, 0, 8);
        System.out.println(Arrays.toString(arr));
    }
}
