package algorithm_10_dp;

public class p21_m377组合总和Ⅳ {
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int res = combinationSum4(nums, 4);
        System.out.println(res);
    }
}
