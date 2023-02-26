package algorithm_10_dp;

import java.util.Arrays;

public class p43_m718最长重复子数组 {
    public static int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;
        for (int i = 1; i < nums2.length + 1; i++) {
            for (int j = 1; j < nums1.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(dp[i][j], res);
                }
            }
        }
        return res;

    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4,7};
        int res = findLength(nums1, nums2);
        System.out.println(res);
    }
}
