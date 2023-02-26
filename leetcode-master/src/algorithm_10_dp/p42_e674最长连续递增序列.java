package algorithm_10_dp;

import java.util.Arrays;

public class p42_e674最长连续递增序列 {
    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        int res = findLengthOfLCIS(nums);
        System.out.println(res);
    }
}
