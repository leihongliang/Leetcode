package algorithm_10_dp;

public class p13_m416分割等和子集 {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;
        int bagWeight = sum / 2;
        int[] dp = new int[bagWeight + 1];
        for (int i =0; i < nums.length; i++) {
            for (int j = bagWeight;j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[bagWeight] == bagWeight;
    }



    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        boolean res = canPartition(nums);
        System.out.println(res);
    }
}
