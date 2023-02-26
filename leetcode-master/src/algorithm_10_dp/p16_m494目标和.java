package algorithm_10_dp;

public class p16_m494目标和 {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((target + sum) % 2 == 1) {
            return 0;
        }
        int bagWeight = (target + sum) / 2;
        int[] dp = new int[bagWeight + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagWeight; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
//        return sum - 2 * dp[bagWeight];
        return dp[bagWeight];
    }



    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int res = findTargetSumWays(nums, 3);
        System.out.println(res);
    }
}
