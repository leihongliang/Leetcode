package algorithm_01_array;
import java.util.Arrays;

public class sort_mergeSort {
    public static void main(String[] args) {
        int[] arr = {7,3,1,2,5,8,6,4,9};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort0(int[] arr, int l, int r) {
        if (l >= r) return;
        int m = l + (r - l)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, r, m);
    }

    public static void merge0(int[] arr, int l, int r, int m) {
        int[] tmp = new int[r - l + 1];
        int i = l;
        int j = m + 1;
        int k = 0;
        while (i <= m && j <= r) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while(i <= m) tmp[k++] = arr[i++];
        while(j <= r) tmp[k++] = arr[j++];
        for (i = 0; i < k; i++) {
            arr[l++] = tmp[i];
        }
    }
    private static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int m = l + (r -l) / 2;
        mergeSort(arr, l , m);
        mergeSort(arr, m+1 , r);
        merge(arr, l, r, m);
    }

    private static void merge(int[] arr, int l, int r, int m) {
        int[] tmp = new int[r - l + 1];
        int i  = l;
        int j  = m+1;
        int k  = 0;
        while (i <= m && j <= r) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            }else {
                tmp[k++] = arr[j++];
            }
        }
        while(i <= m) tmp[k++] = arr[i++];
        while(j <= r) tmp[k++] = arr[j++];
        for (i = 0; i < k; i++) {
            arr[l++] = tmp[i];
        }
    }


}
