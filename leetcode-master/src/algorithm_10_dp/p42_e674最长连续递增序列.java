package algorithm_10_dp;

import java.util.Arrays;

public class p42_e674最长连续递增序列 {
    public static int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};
        int res = lengthOfLIS(nums);
        System.out.println(res);
    }
}
