package algorithm_10_dp;

public class p29_m198打家劫舍 {
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i -2] + nums[i - 1]);
        }
        return dp[nums.length];
    }

    // better
    public static int rob2(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i -2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static int rob3(int[] nums) {
        int[] dp = new int[nums.length];
        // 初始化头两个数
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], dp[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];

    }



    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int res = rob3(nums);
        System.out.println(res);
    }
}
