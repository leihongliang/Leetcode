package test;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 5, 4, 8};
        int[] result = mergeSort(array);
        System.out.println(Arrays.toString(result));
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int middle = arr.length / 2;
        int[] arr1 = Arrays.copyOfRange(arr, 0, middle);
        int[] arr2 = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(mergeSort(arr1), mergeSort(arr2));
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] sortArr = new int[arr1.length +arr2.length];
        int idx = 0, idx1=0, idx2=0;
        while (idx1 < arr1.length && idx2 < arr2.length) {
            if (arr1[idx1] < arr2[idx2]) {
                sortArr[idx] = arr1[idx1];
                idx1 += 1;
            }else {
                sortArr[idx] = arr2[idx2];
                idx2 +=1;
            }
            idx +=1;
        }
        if (idx1 < arr1.length) {
            while (idx1 < arr1.length) {
                sortArr[idx] = arr1[idx1];
                idx1 += 1;
                idx +=1;
            }
        } else {
            while (idx2 < arr2.length) {
                sortArr[idx] = arr2[idx2];
                idx2 += 1;
                idx += 1;
            }
        }

        return sortArr;

    }

}
