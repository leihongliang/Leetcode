package algorithm_10_dp;

public class p30_m213打家劫舍II {
    public static int rob(int[] nums) {
        int r = nums.length - 1;
        return Math.max(robAction(nums, 1, r), robAction(nums, 0, r - 1));
    }
    static int robAction(int[] nums, int l, int r) {
        if (r - l == 0) return nums[r];
        int[] dp = new int[r - l + 1];
        dp[0] = nums[l];
        dp[1] = Math.max(dp[0], nums[l + 1]);
        for (int i = 2; i < r - l + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[l + i]);
        }
        return dp[r - l];
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        int res = rob(nums);
//        int res = robAction(nums, 0, 2);
        System.out.println(res);
    }
}
