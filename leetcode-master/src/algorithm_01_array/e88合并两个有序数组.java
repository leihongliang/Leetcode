package algorithm_01_array;

import java.util.Arrays;

public class e88合并两个有序数组 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m;
        int j = n;
        while (i > 0 || j > 0) {
            if (i == 0) {
                nums1[i + j - 1] = nums2[--j];
            }else if (j == 0) {
                nums1[i + j - 1] = nums1[--i];
            }else if (nums1[i - 1] >= nums2[j - 1]) {
                nums1[i + j - 1] = nums1[--i];
            }else {
                nums1[i + j - 1] = nums2[--j];
            }
        }
    }

    public static void main(String[] args) {
        int [] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
//        int[] nums1 = {0};
//        int m = 0;
//        int[] nums2 = {1};
//        int n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
